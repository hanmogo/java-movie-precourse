package service;

import domain.*;
import domain.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {

    private final PriceCalculator calculator;

    public ReservationService(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    private Map<Long, List<Seat>> bookedSeatsByScreening = new HashMap<>();



    public ReservationResult reserve(User user, Screening screening, List<Seat> selectedSeats, Movie movie,
                        int pointsToUse, PaymentMethod paymentMethod, PriceCalculator calculator) {
        // 좌석 중복 검사
        validateSeats(screening, selectedSeats);

        //유효성 검증
        validateSeats(screening, selectedSeats);

        // 가격 계산
        int basePrice = calculator.calculateBasePrice(selectedSeats);
        int priceAfterDiscounts = calculator.applyDiscounts(basePrice, screening);
        int priceAfterPoints = priceAfterDiscounts - pointsToUse; // 포인트 사용은 단순 차감
        int finalPrice = calculator.applyPaymentDiscount(priceAfterPoints, paymentMethod);

        // 사용자 포인트 차감
        user.usePoints(pointsToUse);

        // 좌석 예약 처리
        bookSeats(screening, selectedSeats);

        // 예매 내역 생성
        Reservation reservation = new Reservation(1L, LocalDateTime.now() , screening.getScreeningId(), user.getUserId());

        // 최종 결과 반환
        return new ReservationResult(reservation, user, selectedSeats, finalPrice);
    }



    private void validateSeats(Screening screening, List<Seat> selectedSeats) {
        List<Seat> bookedSeats = bookedSeatsByScreening.getOrDefault(screening.getScreeningId(), new ArrayList<>());
        for (Seat selectedSeat : selectedSeats) {
            if (bookedSeats.contains(selectedSeat)) {
                throw new IllegalArgumentException("이미 예약된 좌석이 포함되어 있습니다.");
            }
        }
    }

    private void bookSeats(Screening screening, List<Seat> selectedSeats) {
        List<Seat> bookedSeats = bookedSeatsByScreening.getOrDefault(screening.getScreeningId(), new ArrayList<>());
        bookedSeats.addAll(selectedSeats);
        bookedSeatsByScreening.put(screening.getScreeningId(), bookedSeats);
    }

}


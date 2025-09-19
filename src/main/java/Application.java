import domain.Movie;
import domain.enums.PaymentMethod;
import domain.PriceCalculator;
import domain.ReservationResult;
import domain.Screening;
import domain.Seat;
import domain.User;
import service.ReservationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Application {
    private static PriceCalculator calculator;

    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        //PriceCalculator를 ReservationService에 주입하며 메인 서비스를 생성
        ReservationService reservationService = new ReservationService(calculator);

        // 모든 객체가 잘 연결되었는지 확인하기 위한 테스트 실행
        runSampleReservation(reservationService);
    }

    // 모든 로직이 잘 동작하는지 확인하기 위한 예시 메서드
    public static void runSampleReservation(ReservationService reservationService) {

        System.out.println("한글 왜 안댐?");

        System.out.println("====== 샘플 ======");

        // given: 예매에 필요한 데이터 준비
        User user = new User(1L, "김철수", "test@test.com", "010-1234-5678", LocalDate.of(1995, 5, 10), 10000);
        Movie movie = new Movie(1L, "어벤져스: 엔드게임", 181);
        Screening screening = new Screening(1L, LocalDateTime.of(2025, 9, 20, 10, 0), 1L, 1L);
        Seat seatS = new Seat(1L, 1L, "A", 1, Seat.SeatGrade.S);
        Seat seatA = new Seat(2L, 1L, "A", 2, Seat.SeatGrade.A);
        List<Seat> selectedSeats = List.of(seatS, seatA);
        int pointsToUse = 3000;
        PaymentMethod paymentMethod = PaymentMethod.CREDITCARD;

        // when: 예매 서비스 실행
        try {
            ReservationResult result = reservationService.reserve(
                    user, screening, selectedSeats, movie, pointsToUse, paymentMethod);

            // then: 결과 확인
            System.out.println("예매가 성공적으로 완료되었습니다.");
            System.out.println("최종 결제 금액: " + result.getFinalPrice() + "원");
            System.out.println(user.getName() + "님의 남은 포인트: " + user.getPoint() + "점");

        } catch (IllegalArgumentException e) {
            System.out.println("예매 실패: " + e.getMessage());
        }
        System.out.println("============================");
    }
}
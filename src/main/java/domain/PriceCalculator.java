package domain;

import domain.enums.PaymentMethod;

import java.time.LocalTime;
import java.util.List;


public class PriceCalculator {

    //기본 좌석 가격 계산
    public int calculateBasePrice(List<Seat> seats) {
        int totalPrice = 0;
        for (Seat seat : seats) {
            totalPrice += seat.getPrice();
        }
        return totalPrice;
    }

    //조건부 할인 적용
    public int applyDiscounts(int price, Screening screening) {
        int priceAfterMovieDay = applyMovieDayDiscount(price, screening);
        int finalPrice = applyTimeDiscount(priceAfterMovieDay, screening);
        return finalPrice;
    }

    //최종 결제 수단 할인
    public int applyPaymentDiscount(int price, PaymentMethod paymentMethod) {
        if (paymentMethod == PaymentMethod.CREDITCARD) {
            return (int) (price * 0.95);
        }
        if (paymentMethod == PaymentMethod.CASH) {
            return (int) (price * 0.98);
        }
        return price;
    }

    // private 헬퍼 메서드들
    private int applyMovieDayDiscount(int price, Screening screening) {
        int dayOfMonth = screening.getStartTime().getDayOfMonth();
        if (dayOfMonth == 10 || dayOfMonth == 20 || dayOfMonth == 30) {
            return (int) (price * 0.9);
        }
        return price;
    }

    private int applyTimeDiscount(int price, Screening screening) {
        LocalTime startTime = screening.getStartTime().toLocalTime();
        // 오후 8시 이후 조건 수정
        if (startTime.isBefore(LocalTime.of(11, 0)) || !startTime.isBefore(LocalTime.of(20, 0))) {
            return price - 2000;
        }
        return price;
    }
}
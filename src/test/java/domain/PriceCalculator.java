package domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class PriceCalculator {

    //좌석 값 계산
    public int calculatePrice(List<Seat> seats) {
        int totalPrice = 0;
        for (Seat seat : seats) {
            totalPrice += seat.getPrice();
        }
        return totalPrice;
    }


    //무비데이 + 시간조건 할인 적용
    public int applyDiscounts(int basePrice, Screening screening) {
        int priceAfterMovieDay = applyMovieDayDiscount(basePrice, screening);
        int finalPrice = applyTimeDiscount(priceAfterMovieDay, screening);
        return finalPrice;
    }


    //무비데이 할인 적용
    public int applyMovieDayDiscount(int basePrice, Screening movingDayScreening) {

        int dayOfMonth = movingDayScreening.getStartTime().getDayOfMonth();

        if (dayOfMonth == 10 || dayOfMonth == 20 || dayOfMonth == 30) {
            return (int) (basePrice * 0.9);
        }
        return basePrice;
    }


    //시간 조건 할인
    public int applyTimeDiscount(int basePrice, Screening timeScreening) {

        LocalTime startTime = timeScreening.getStartTime().toLocalTime();
        if(startTime.isBefore(LocalTime.of(11, 0))||startTime.isAfter(LocalTime.of(20, 0))) {
            return basePrice - 2000;
        }
        return basePrice;
    }
}


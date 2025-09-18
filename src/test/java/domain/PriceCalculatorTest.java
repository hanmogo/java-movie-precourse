package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.Authenticator;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PriceCalculatorTest {

    @Test
    @DisplayName("선택한 좌석 목록의 기본 총액을 정확하게 계산한다.")
    void calculatePrice(){
        //given
        Seat seat1 = new Seat(1L, 1L, "A" ,1, Seat.SeatGrade.S);
        Seat seat2 = new Seat(2L, 1L, "B" ,1, Seat.SeatGrade.B);
        Seat seat3 = new Seat(3L, 1L, "B" ,2, Seat.SeatGrade.A);
        List<Seat> selectedSeats = List.of(seat1, seat2, seat3);

        PriceCalculator priceCalculator = new PriceCalculator();
        int expectedPrice = 18000 + 12000 + 15000;

        //when 실행
        int actualPrice = priceCalculator.calculatePrice(selectedSeats);

        //then 겁증
        assertThat(actualPrice).isEqualTo(expectedPrice);

    }

    @Test
    @DisplayName("무비데이(10일, 20일, 30일)에는 총액에서 10% 할인이 적용된다.")
    void applyMovieDayDiscount(){
        //given
        int basePrice = 20000;
        //상영날짜 10일로 설정한 객체 생성
        LocalDateTime screeningDateTime = LocalDateTime.of(2025, 9, 10, 14, 30);
        Screening movingDayScreening = new Screening(1L, screeningDateTime, 1L, 1L);

        PriceCalculator priceCalculator = new PriceCalculator();
        int expectedPrice = 18000;

        //when
        int actualPrice = priceCalculator.applyDiscounts(basePrice, movingDayScreening);

        //then
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("오전 11시 이전 또는 오후 8시 이후에 시작하는 상영은 2,000원이 할인된다.")
    void applyTimeDiscount(){
        //given
        int basePrice = 20000;
        // 무비데이가 아닌 날, 할인 시간으로 설정
        LocalDateTime screeningDateTime = LocalDateTime.of(2025, 9, 11, 10, 59);
        Screening timeConditionScreening = new Screening(1L, screeningDateTime, 1L, 1L);

        PriceCalculator priceCalculator = new PriceCalculator();
        int expectedPrice = 18000;

        //when
        int actualPrice = priceCalculator.applyTimeDiscount(basePrice,  timeConditionScreening);

        //then
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("무비데이 할인과 시간 조건 할인 동시 적용 테스트")
    void applyBothDiscountsMovindAndTime(){
        //given
        int basePrice = 20000;

        LocalDateTime screeningDateTime = LocalDateTime.of(2025, 9, 20, 10, 59);
        Screening bothScreening = new Screening(1L, screeningDateTime, 1L, 1L);

        PriceCalculator priceCalculator = new PriceCalculator();
        int expectedPrice = 16000;

        //when
        int actualPrice = priceCalculator.applyDiscounts(basePrice, bothScreening);

        //then
        assertThat(actualPrice).isEqualTo(expectedPrice);
        System.out.println(actualPrice);
    }

}

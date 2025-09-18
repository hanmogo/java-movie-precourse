package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PriceCalculatorTest {

    @Test
    @DisplayName("선택한 좌석 목록의 기본 총액을 정확하게 계산함")
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

}

package domain;

import domain.enums.PaymentMethod;
import service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReservationServiceTest {

    private PriceCalculator calculator;

    @Test
    @DisplayName("이미 예약된 좌석을 포함하여 예매를 시도하면 예외가 발생한다.")
    void reserveFailsWhenSeatIsAlreadyBooked(){
        //given
        ReservationService reservationService = new ReservationService(calculator);
        User user = new User(1L, "test", "test@test.com", "010-0000-0000", LocalDate.of(2002, 06, 03), 5000);
        Movie movie = new Movie(1L, "영화1", 120);
        Screening screening = new Screening(1L, LocalDateTime.now(), 1L, 1L);
        Seat seat1 = new Seat(1L, 1L, "A", 1, Seat.SeatGrade.S);
        Seat seat2 = new Seat(2L, 1L, "A", 2, Seat.SeatGrade.S);

        int pointsToUse = 0;
        PaymentMethod paymentMethod = PaymentMethod.CASH;
        PriceCalculator calculator = new PriceCalculator();
        // 먼저 seat1 좌석을 예약해서 선점 상태로 만듦
        reservationService.reserve(user, screening, List.of(seat1), movie, pointsToUse, paymentMethod);

        // when, then
        // 이미 예약된 seat1을 포함하여 다시 예매를 시도하면 예외가 발생해야 함
        assertThatThrownBy(() -> {
            reservationService.reserve(user, screening, List.of(seat1, seat2), movie, pointsToUse, paymentMethod);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 예약된 좌석이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("모든 할인과 포인트 사용을 포함한 전체 예매 과정이 성공적으로 이루어진다.")
    void reserveSuccessWithAllConditions() {
        // given
        ReservationService reservationService = new ReservationService(calculator);
        PriceCalculator calculator = new PriceCalculator(); // PriceCalculator도 사용

        User user = new User(1L, "test", "test@test.com", "010-0000-0000", LocalDate.of(2002, 6, 3), 10000);
        Movie movie = new Movie(1L, "영화1", 120);
        // 할인 동시 적용되는 상영
        Screening screening = new Screening(1L, LocalDateTime.of(2025, 9, 20, 10, 0), 1L, 1L );
        Seat seatS = new Seat(1L, 1L, "A", 1, Seat.SeatGrade.S);
        Seat seatA = new Seat(2L, 1L, "A", 2, Seat.SeatGrade.A);
        List<Seat> selectedSeats = List.of(seatS, seatA);

        int pointsToUse = 3000;
        PaymentMethod paymentMethod = PaymentMethod.CREDITCARD;
        int expectedFinalPrice = 23465;

        // when
        ReservationResult result = reservationService.reserve(
                user, screening, selectedSeats, movie, pointsToUse, paymentMethod);

        // then
        assertThat(result.getFinalPrice()).isEqualTo(expectedFinalPrice);
        assertThat(result.getUser().getPoint()).isEqualTo(7000); // 10000 - 3000
        assertThat(result.getReservedSeats()).containsExactlyInAnyOrder(seatS, seatA);
    }

}

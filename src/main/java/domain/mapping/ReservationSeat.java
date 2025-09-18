package domain.mapping;

public class ReservationSeat {

    private Long ReservationSeatId;
    private Long reservationId;
    private Long seatId;

    public ReservationSeat(Long ReservationSeatId, Long reservationId, Long seatId) {
        this.ReservationSeatId = ReservationSeatId;
        this.reservationId = reservationId;
        this.seatId = seatId;
    }

    //getter

    public Long getSeatId() {
        return seatId;
    }

    public Long getReservationSeatId() {
        return ReservationSeatId;
    }

    public Long getReservationId() {
        return reservationId;
    }
}

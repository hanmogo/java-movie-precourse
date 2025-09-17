package domain;

public class Reservation {

    private Long reservationId;
    private String reservationTime;
    private Long userId;
    private Long screenId;

    public Reservation(Long reservationId, String reservationTime, Long userId, Long screenId) {
        this.reservationId = reservationId;
        this.reservationTime = reservationTime;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getScreenId() {
        return screenId;
    }
}

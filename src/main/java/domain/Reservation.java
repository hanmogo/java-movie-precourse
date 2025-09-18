package domain;

import java.time.LocalDateTime;

public class Reservation {

    private Long reservationId;
    private LocalDateTime reservationTime;
    private Long userId;
    private Long screenId;

    public Reservation(Long reservationId, LocalDateTime reservationTime, Long userId, Long screenId) {
        this.reservationId = reservationId;
        this.reservationTime = reservationTime;
        this.userId = userId;
        this.screenId = screenId;
    }

    //getter
    public Long getReservationId() {
        return reservationId;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getScreenId() {
        return screenId;
    }
}

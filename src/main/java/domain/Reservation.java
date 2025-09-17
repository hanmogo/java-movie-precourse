package domain;

public class Reservation {

    private Long id;
    private String reservation_time;

    public Reservation(Long id, String reservation_time) {
        this.id = id;
        this.reservation_time = reservation_time;
    }

    public Long getId() {
        return id;
    }

    public String getReservation_time() {
        return reservation_time;
    }
}

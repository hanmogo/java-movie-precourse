package domain;

import java.util.List;

public class ReservationResult {
    private  Reservation reservation;
    private User user;
    private List<Seat> reservedSeats;
    private int finalPrice;

    public ReservationResult(Reservation reservation, User user, List<Seat> reservedSeats, int finalPrice){
        this.reservation = reservation;
        this.user = user;
        this.reservedSeats = reservedSeats;
        this.finalPrice = finalPrice;
    }


    public Reservation getReservation() {
        return reservation;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}

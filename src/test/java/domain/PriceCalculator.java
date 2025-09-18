package domain;

import java.util.List;

public class PriceCalculator {

    public int calculatePrice(List<Seat> seats) {
        int totalPrice = 0;
        for (Seat seat : seats) {
            totalPrice += seat.getPrice();
        }
        return totalPrice;
    }
}


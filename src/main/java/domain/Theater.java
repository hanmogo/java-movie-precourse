package domain;

public class Theater {

    private Long theaterId;
    private String name;
    private int totalSeat;

    public Theater(Long theaterId, String name, int totalSeat) {
        this.theaterId = theaterId;
        this.name = name;
        this.totalSeat = totalSeat;
    }

    //getter
    public Long getTheaterId() {
        return theaterId;
    }

    public String getName() {
        return name;
    }

    public int getTotalSeat() {
        return totalSeat;
    }
}

package domain;

public class Seat {

    private String id;
    private String seat_row;
    private int seat_column;
    private String grade;
    private int price;

    public Seat(String id, String seat_row, int seat_column, String grade, int price) {

        this.id = id;
        this.seat_row = seat_row;
        this.seat_column = seat_column;
        this.grade = grade;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public String getSeat_row() {
        return seat_row;
    }

    public int getSeat_column() {
        return seat_column;
    }

    public String getGrade() {
        return grade;
    }

    public int getPrice() {
        return price;
    }
}

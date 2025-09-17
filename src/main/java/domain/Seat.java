package domain;

public class Seat {

    public enum SeatGrade{ // 등급과 가격이 함께 묶여야 데이터가 바뀔 위험성이 없음
        S(18000), A(15000), B(12000);

        private int price;

        SeatGrade(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }

    private Long seatId;
    private Long theaterId;
    private String seatRow;
    private int seatColumn;
    private SeatGrade grade;

    public Seat(Long seatId, Long theaterId, String seatRow, int seatColumn, SeatGrade grade) {

        this.seatId = seatId;
        this.theaterId = theaterId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.grade = grade;

    }

    public Long getSeatId() {
        return seatId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public String getSeat_row() {
        return seatRow;
    }

    public int getSeat_column() {
        return seatColumn;
    }

    public SeatGrade getGrade() {
        return grade;
    }

    public int getPrice() {
        return grade.getPrice();
    }


}

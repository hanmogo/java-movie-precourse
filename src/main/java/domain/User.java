package domain;

import java.time.LocalDate;


public class User {

    private Long userId;
    private String name;
    private String email;
    private String phoneNum;
    private LocalDate birthDate;
    private int point;

    public User(Long userId, String name, String email, String phoneNum, LocalDate birthDate, int point) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birthDate = birthDate;
        this.point = point;
    }

    //getter
    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPoint() {
        return point;
    }

    //사용할 포인트
    public void usePoints(int pointsToUse){
        if (pointsToUse > this.point) {
            throw new IllegalArgumentException("보유한 포인트보다 많이 사용할 수 없습니다.");
        }
        this.point -= pointsToUse;
    }
}

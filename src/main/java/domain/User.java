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

}

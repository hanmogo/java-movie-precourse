package domain;

import java.time.LocalDate;


public class User {

    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private LocalDate birthDate;
    private int ponit;

    public User(Long id, String name, String email, String phoneNum, LocalDate birthDate, int ponit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birthDate = birthDate;
        this.ponit = ponit;
    }

    public Long getId() {
        return id;
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

    public int getPonit() {
        return ponit;
    }

}

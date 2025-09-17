package domain;

import java.time.LocalDateTime;

public class Screening {

    private Long id;
    private LocalDateTime startTime;

    public Screening(Long id, LocalDateTime startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

}

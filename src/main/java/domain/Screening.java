package domain;

import java.time.LocalDateTime;

public class Screening {

    private Long screeningId;
    private LocalDateTime startTime;
    private Long movieId;
    private Long theatherId;

    public Screening(Long screeningId, LocalDateTime startTime, Long movieId, Long theatherId) {
        this.screeningId = screeningId;
        this.startTime = startTime;
        this.movieId = movieId;
        this.theatherId = theatherId;
    }

    public Long getmMovieId() {
        return screeningId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getTheatherId() {
        return theatherId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

}

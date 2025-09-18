package domain;

import java.time.LocalDateTime;

public class Movie {

    private Long movieId;
    private String title;
    private Long runningTime;

    public Movie(Long movieId, String title, Long runningTime) {
        this.movieId = movieId;
        this.title = title;
        this.runningTime = runningTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Long getRunningTime() {
        return runningTime;
    }
}

package domain;

import java.time.LocalDateTime;

public class Movie {

    private Long movieId;
    private String title;
    private int runningTime;

    public Movie(Long movieId, String title, int runningTime) {
        this.movieId = movieId;
        this.title = title;
        this.runningTime = runningTime;
    }

    //getter
    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getRunningTime() {
        return runningTime;
    }
}

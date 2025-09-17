package domain;

public class Movie {

    private Long movieId;
    private String title;
    private String runningTime;

    public Movie(Long movieId, String title, String runningTime) {
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

    public String getRunningTime() {
        return runningTime;
    }
}

package domain;

public class Movie {

    private Long id;
    private String title;
    private String runningTime;

    public Movie(Long id, String title, String runningTime) {
        this.id = id;
        this.title = title;
        this.runningTime = runningTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRunningTime() {
        return runningTime;
    }
}

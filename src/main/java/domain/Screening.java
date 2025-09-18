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

    //getter
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

    //상영 종료 시간
    public LocalDateTime getEndTime(Movie movie){
        if(!movie.getMovieId().equals(this.movieId)){
            throw new IllegalArgumentException("상영 정보와 영화 정보가 일치하지 않습니다.");
        }
        return startTime.plusMinutes(movie.getRunningTime());
    }

    public boolean isOverlapping(Screening other, Movie thisMovie, Movie otherMovie) {
        LocalDateTime thisEndTime = this.getEndTime(thisMovie);
        LocalDateTime otherEndTime = other.getEndTime(otherMovie);

        return this.startTime.isBefore(otherEndTime) && other.startTime.isBefore(thisEndTime);
    }
}

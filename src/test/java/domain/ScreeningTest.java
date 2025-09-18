package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ScreeningTest {

    @Test
    @DisplayName("두 상영 시간표가 겹치는 지 확인한다. ")
    void isOverlapping(){
        //given
        Movie movie1 = new Movie(1L, "어벤져스", 150);
        Movie movie2 = new Movie(2L, "암살", 120);

        Screening screening1 = new Screening(1L, LocalDateTime.of(2025, 9, 18, 15, 0), 1L, 1L);
        Screening overLappingScreening = new Screening(2L, LocalDateTime.of(2025, 9, 18, 17, 0), 2L, 1L);
        Screening nonOverLappingScreening = new Screening(3L, LocalDateTime.of(2025, 9, 18, 21, 0), 2L, 1L);

        //when, then
        assertThat(screening1.isOverlapping(overLappingScreening, movie1, movie2)).isTrue(); //겹치는 경우
        assertThat(screening1.isOverlapping(nonOverLappingScreening, movie1, movie2)).isFalse(); //겹치지 않는 경우

    }

}

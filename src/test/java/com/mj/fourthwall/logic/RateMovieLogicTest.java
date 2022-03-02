package com.mj.fourthwall.logic;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.RateMovieParamsTO;
import com.mj.fourthwall.logic.to.RateMovieResultTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class RateMovieLogicTest {

    private MovieRepository movieRepository;
    private RateMovieLogic rateMovieLogic;
    private Movie movie;

    @BeforeEach
    public void beforeEach(){

        movie = new Movie( "id", "Fast and Furious", 4.7, 10, 13, 30);

        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findById("id")).thenReturn(Optional.of(movie));

        rateMovieLogic = new RateMovieLogic(movieRepository);

    }

    @Test
    public void testRateAMovie(){
        RateMovieParamsTO paramsTO = new RateMovieParamsTO("id", 5);

        RateMovieResultTO resultTO = rateMovieLogic.rateMovie(paramsTO);

        Assertions.assertTrue(resultTO.getRated());
        Assertions.assertEquals(11, movie.getVotes());
        Assertions.assertEquals(4.7272727272727275, movie.getRate());
    }

    @Test
    public void testMovieNotExists(){
        RateMovieParamsTO paramsTO = new RateMovieParamsTO("id2", 5);

        RateMovieResultTO resultTO = rateMovieLogic.rateMovie(paramsTO);

        Assertions.assertFalse(resultTO.getRated());
    }

    @Test
    public void testWrongRate(){
        RateMovieParamsTO paramsTO = new RateMovieParamsTO("id", 7);

        RateMovieResultTO resultTO = rateMovieLogic.rateMovie(paramsTO);

        Assertions.assertFalse(resultTO.getRated());
    }
}
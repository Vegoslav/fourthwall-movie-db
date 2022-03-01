package com.mj.fourthwall.logic;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.RateMovieParamsTO;
import com.mj.fourthwall.logic.to.RateMovieResultTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RateMovieLogic implements IRateMovie {

    private final MovieRepository movieRepository;

    @Override
    public RateMovieResultTO rateMovie(RateMovieParamsTO paramsTO) {
        RateMovieResultTO resultTO;

        Optional<Movie> byId = movieRepository.findById(paramsTO.getId());

        if (byId.isPresent() && paramsTO.getRate() <= 5 && paramsTO.getRate() >= 1) {
            resultTO = rate(paramsTO, byId.get());
        } else {
            resultTO = new RateMovieResultTO(false);
        }

        return resultTO;
    }

    private RateMovieResultTO rate(RateMovieParamsTO paramsTO, Movie movie) {
        RateMovieResultTO resultTO;

        Double rate = (movie.getRate() * movie.getVotes() + paramsTO.getRate()) / (movie.getVotes() + 1);

        movie.setRate(rate);
        movie.setVotes(movie.getVotes() + 1);
        movieRepository.save(movie);
        resultTO = new RateMovieResultTO(true);
        return resultTO;
    }
}

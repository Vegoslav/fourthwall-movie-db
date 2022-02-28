package com.mj.fourthwall.logic;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.MovieTimeParamsTO;
import com.mj.fourthwall.logic.to.MovieTimeResultTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MovieTimeLogic implements IMovieTime{

    private final MovieRepository movieRepository;

    @Override
    public MovieTimeResultTO movieTime(MovieTimeParamsTO paramsTO) {
        MovieTimeResultTO resultTO;

        Optional<Movie> byId = movieRepository.findById(paramsTO.getId());

        resultTO = byId.map(movie -> new MovieTimeResultTO(movie.getHours(), movie.getMinutes(), true)).orElseGet(() -> new MovieTimeResultTO(null, null, false));

        return resultTO;
    }
}

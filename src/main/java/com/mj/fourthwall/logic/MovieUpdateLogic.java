package com.mj.fourthwall.logic;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.MovieUpdateParamsTO;
import com.mj.fourthwall.logic.to.MovieUpdateResultTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MovieUpdateLogic implements IUpdateMovie{

    private final MovieRepository movieRepository;

    @Override
    public MovieUpdateResultTO updateMovie(MovieUpdateParamsTO paramsTO) {
        MovieUpdateResultTO resultTO;

        Optional<Movie> byId = movieRepository.findById(paramsTO.getId());

        if(byId.isPresent()){
            Movie movie = byId.get();
            movie.setHours(paramsTO.getHours());
            movie.setMinutes(paramsTO.getMinutes());

            movieRepository.save(movie);
            resultTO = new MovieUpdateResultTO(true);
        }
        else {
            resultTO = new MovieUpdateResultTO(false);
        }

        return resultTO;
    }
}

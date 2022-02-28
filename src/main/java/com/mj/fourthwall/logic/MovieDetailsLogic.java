package com.mj.fourthwall.logic;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.MovieDetailsParamsTO;
import com.mj.fourthwall.logic.to.MovieDetailsResultTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MovieDetailsLogic implements IMovieDetails {

    private final MovieRepository movieRepository;

    @Override
    public MovieDetailsResultTO movieDetails(MovieDetailsParamsTO paramsTO) {
        MovieDetailsResultTO resultTO;
        Optional<Movie> byId = movieRepository.findById(paramsTO.getId());

        if (byId.isPresent()) {
            resultTO = MovieDetailsResultTO.builder()
                    .id(byId.get().getId())
                    .title(byId.get().getTitle())
                    .found(true)
                    .build();
        } else {
            resultTO = MovieDetailsResultTO.builder().found(false).build();
        }

        return resultTO;
    }
}

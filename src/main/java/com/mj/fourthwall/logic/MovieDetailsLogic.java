package com.mj.fourthwall.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import com.mj.fourthwall.logic.to.MovieDetailsParamsTO;
import com.mj.fourthwall.logic.to.MovieDetailsResultTO;
import com.mj.fourthwall.webservice.OMDBAPIService;
import com.mj.fourthwall.webservice.to.OMDBMovieTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MovieDetailsLogic implements IMovieDetails {

    private final MovieRepository movieRepository;
    private final OMDBAPIService omdbapiService;

    @Override
    public MovieDetailsResultTO movieDetails(MovieDetailsParamsTO paramsTO) {
        MovieDetailsResultTO resultTO;
        Optional<Movie> byId = movieRepository.findById(paramsTO.getId());

        if (byId.isPresent()) {

            OMDBMovieTO movieDetails = OMDBMovieTO.builder().build();
            try {
                movieDetails = omdbapiService.getMovieDetails(paramsTO.getId());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            resultTO = MovieDetailsResultTO.builder()
                    .id(byId.get().getId())
                    .title(byId.get().getTitle())
                    .actors(movieDetails.getActors())
                    .country(movieDetails.getCountry())
                    .genre(movieDetails.getGenre())
                    .language(movieDetails.getLanguage())
                    .metascore(movieDetails.getMetascore())
                    .rated(movieDetails.getRated())
                    .released(movieDetails.getReleased())
                    .year(movieDetails.getYear())
                    .rate(byId.get().getRate())
                    .found(true)
                    .build();
        } else {
            resultTO = MovieDetailsResultTO.builder().found(false).build();
        }

        return resultTO;
    }
}

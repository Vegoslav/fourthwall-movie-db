package com.mj.fourthwall.controller;

import com.mj.fourthwall.controller.to.MovieDetailsResponseTO;
import com.mj.fourthwall.controller.to.MovieTimeResponseTO;
import com.mj.fourthwall.controller.to.RateMovieRequestTO;
import com.mj.fourthwall.controller.to.RateMovieResponseTO;
import com.mj.fourthwall.logic.IMovieDetails;
import com.mj.fourthwall.logic.IMovieTime;
import com.mj.fourthwall.logic.IRateMovie;
import com.mj.fourthwall.logic.to.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private IMovieTime movieTime;
    private IMovieDetails movieDetails;
    private IRateMovie rateMovie;

    @GetMapping("/movie/{id}/time")
    public MovieTimeResponseTO movieTime(@PathVariable String id) {
        MovieTimeResponseTO movieTimeResponseTO = checkMovieTime(id);

        return movieTimeResponseTO;
    }

    @GetMapping("/movie/{id}")
    public MovieDetailsResponseTO movieDetails(@PathVariable String id) {
        MovieDetailsResponseTO movieDetailsResponseTO = checkMovieDetails(id);

        return movieDetailsResponseTO;
    }

    @PostMapping("/movie/{id}/rate")
    public RateMovieResponseTO movieRate(@RequestBody RateMovieRequestTO request, @PathVariable String id) {
        RateMovieResponseTO rateMovieResponseTO = rateMovie(request, id);

        return rateMovieResponseTO;
    }

    private MovieTimeResponseTO checkMovieTime(String id) {
        MovieTimeParamsTO movieTimeParamsTO = new MovieTimeParamsTO(id);
        MovieTimeResultTO movieTimeResultTO = movieTime.movieTime(movieTimeParamsTO);

        MovieTimeResponseTO movieTimeResponseTO = new MovieTimeResponseTO(movieTimeResultTO.getHour(), movieTimeResultTO.getMinutes());
        return movieTimeResponseTO;
    }

    private MovieDetailsResponseTO checkMovieDetails(String id) {
        MovieDetailsParamsTO movieDetailsParamsTO = new MovieDetailsParamsTO(id);
        MovieDetailsResultTO movieDetailsResultTO = movieDetails.movieDetails(movieDetailsParamsTO);

        MovieDetailsResponseTO movieDetailsResponseTO = convertMovieResultToResponse(movieDetailsResultTO);
        return movieDetailsResponseTO;
    }

    private MovieDetailsResponseTO convertMovieResultToResponse(MovieDetailsResultTO movieDetailsResultTO) {
        MovieDetailsResponseTO movieDetailsResponseTO = MovieDetailsResponseTO.builder()
                .title(movieDetailsResultTO.getTitle())
                .actors(movieDetailsResultTO.getActors())
                .country(movieDetailsResultTO.getCountry())
                .genre(movieDetailsResultTO.getGenre())
                .id(movieDetailsResultTO.getId())
                .language(movieDetailsResultTO.getLanguage())
                .metascore(movieDetailsResultTO.getMetascore())
                .rated(movieDetailsResultTO.getRated())
                .released(movieDetailsResultTO.getReleased())
                .year(movieDetailsResultTO.getYear())
                .rate(movieDetailsResultTO.getRate())
                .build();
        return movieDetailsResponseTO;
    }

    private RateMovieResponseTO rateMovie(RateMovieRequestTO request, String id) {
        RateMovieParamsTO rateMovieParamsTO = new RateMovieParamsTO(id, request.getRate());
        RateMovieResultTO rateMovieResultTO = rateMovie.rateMovie(rateMovieParamsTO);

        RateMovieResponseTO rateMovieResponseTO = new RateMovieResponseTO(rateMovieResultTO.getRated());

        return rateMovieResponseTO;
    }
}

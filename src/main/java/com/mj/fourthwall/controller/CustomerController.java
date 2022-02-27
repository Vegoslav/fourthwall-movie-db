package com.mj.fourthwall.controller;

import com.mj.fourthwall.controller.to.MovieDetailsResponseTO;
import com.mj.fourthwall.controller.to.MovieTimeResponseTO;
import com.mj.fourthwall.controller.to.RateMovieRequestTO;
import com.mj.fourthwall.controller.to.RateMovieResponseTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @GetMapping("/movie/{id}/time")
    public MovieTimeResponseTO movieTime(@PathVariable Long id) {
        MovieTimeResponseTO movieTimeResponseTO = null;

        return movieTimeResponseTO;
    }

    @GetMapping("/movie/{id}")
    public MovieDetailsResponseTO movieDetails(@PathVariable Long id) {
        MovieDetailsResponseTO movieDetailsResponseTO = null;

        return movieDetailsResponseTO;
    }

    @PostMapping("/movie/{id}/rate")
    public RateMovieResponseTO movieRate(@RequestBody RateMovieRequestTO request, @PathVariable Long id) {
        RateMovieResponseTO rateMovieResponseTO = null;

        return rateMovieResponseTO;
    }
}

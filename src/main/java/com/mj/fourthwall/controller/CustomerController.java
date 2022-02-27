package com.mj.fourthwall.controller;

import com.mj.fourthwall.controller.to.MovieDetailsResponseTO;
import com.mj.fourthwall.controller.to.MovieTimeResponseTO;
import com.mj.fourthwall.controller.to.RateMovieRequestTO;
import com.mj.fourthwall.controller.to.RateMovieResponseTO;
import com.mj.fourthwall.logic.IMovieDetails;
import com.mj.fourthwall.logic.IMovieTime;
import com.mj.fourthwall.logic.IRateMovie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private IMovieTime movieTime;
    private IMovieDetails movieDetails;
    private IRateMovie rateMovie;

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

package com.mj.fourthwall.controller;

import com.mj.fourthwall.controller.to.MovieUpdateRequestTO;
import com.mj.fourthwall.controller.to.MovieUpdateResponseTO;
import com.mj.fourthwall.logic.IUpdateMovie;
import com.mj.fourthwall.logic.to.MovieUpdateParamsTO;
import com.mj.fourthwall.logic.to.MovieUpdateResultTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OwnerController {

    private IUpdateMovie updateMovie;

    @PostMapping("/manage/movie/{id}/update")
    public MovieUpdateResponseTO movieUpdate(@RequestBody MovieUpdateRequestTO request, @PathVariable String id) {
        MovieUpdateResponseTO movieUpdateResponseTO = updateMovie(request, id);

        return movieUpdateResponseTO;
    }

    private MovieUpdateResponseTO updateMovie(MovieUpdateRequestTO request, String id) {
        MovieUpdateParamsTO movieUpdateParamsTO = new MovieUpdateParamsTO(id, request.getHour(), request.getMinutes());
        MovieUpdateResultTO movieUpdateResultTO = updateMovie.updateMovie(movieUpdateParamsTO);

        MovieUpdateResponseTO movieUpdateResponseTO = new MovieUpdateResponseTO(movieUpdateResultTO.getUpdated());
        return movieUpdateResponseTO;
    }

}

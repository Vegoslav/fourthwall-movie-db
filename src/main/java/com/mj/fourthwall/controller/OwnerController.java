package com.mj.fourthwall.controller;

import com.mj.fourthwall.controller.to.MovieUpdateRequestTO;
import com.mj.fourthwall.controller.to.MovieUpdateResponseTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @PostMapping("/manage/movie/{id}/update")
    public MovieUpdateResponseTO movieUpdate(@RequestBody MovieUpdateRequestTO request, @PathVariable Long id) {
        return null;
    }

}

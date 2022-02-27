package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RateMovieResponseTO {

    Boolean rated;

    @JsonCreator
    public RateMovieResponseTO(@JsonProperty("rated") Boolean rated) {
        this.rated = rated;
    }

}

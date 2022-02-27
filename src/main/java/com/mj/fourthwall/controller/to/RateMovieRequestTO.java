package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RateMovieRequestTO {

    Integer rate;

    @JsonCreator
    public RateMovieRequestTO(@JsonProperty("rate") Integer rate){
        this.rate = rate;
    }
}

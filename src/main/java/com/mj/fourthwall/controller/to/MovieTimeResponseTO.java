package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MovieTimeResponseTO {

    Integer hour;
    Integer minutes;

    @JsonCreator
    public MovieTimeResponseTO(@JsonProperty("hour") Integer hour,
                               @JsonProperty("minutes") Integer minutes){
        this.hour = hour;
        this.minutes = minutes;
    }
}

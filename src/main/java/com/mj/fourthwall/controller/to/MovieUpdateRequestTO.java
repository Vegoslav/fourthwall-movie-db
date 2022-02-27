package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MovieUpdateRequestTO {

    Double price;
    Integer hour;
    Integer minutes;

    @JsonCreator
    public MovieUpdateRequestTO(@JsonProperty("price") Double price,
                                @JsonProperty("hour") Integer hour,
                                @JsonProperty("minutes") Integer minutes) {
        this.price = price;
        this.hour = hour;
        this.minutes = minutes;
    }

}

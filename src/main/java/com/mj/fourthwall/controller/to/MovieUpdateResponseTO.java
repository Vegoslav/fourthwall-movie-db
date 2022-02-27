package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MovieUpdateResponseTO {

    Boolean updated;

    @JsonCreator
    public MovieUpdateResponseTO(@JsonProperty("updated") Boolean updated){
        this.updated = updated;
    }

}

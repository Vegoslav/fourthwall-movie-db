package com.mj.fourthwall.webservice.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RatingTO {
    String source;
    String value;

    @JsonCreator
    public RatingTO(@JsonProperty("source") String source, @JsonProperty("value") String value){
        this.source = source;
        this.value = value;
    }
}

package com.mj.fourthwall.logic.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RateMovieParamsTO {
    Long id;
    Integer rate;
}

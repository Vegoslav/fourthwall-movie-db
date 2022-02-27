package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.RateMovieParamsTO;
import com.mj.fourthwall.logic.to.RateMovieResultTO;
import org.springframework.stereotype.Component;

@Component
public class RateMovieLogic implements IRateMovie{

    @Override
    public RateMovieResultTO rateMovie(RateMovieParamsTO paramsTO) {
        return null;
    }
}

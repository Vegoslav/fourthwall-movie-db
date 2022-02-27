package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.RateMovieParamsTO;
import com.mj.fourthwall.logic.to.RateMovieResultTO;

public interface IRateMovie {

    RateMovieResultTO rateMovie(RateMovieParamsTO paramsTO);
}

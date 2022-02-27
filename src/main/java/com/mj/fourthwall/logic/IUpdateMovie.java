package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.MovieUpdateParamsTO;
import com.mj.fourthwall.logic.to.MovieUpdateResultTO;

public interface IUpdateMovie {

    MovieUpdateResultTO updateMovie(MovieUpdateParamsTO paramsTO);
}

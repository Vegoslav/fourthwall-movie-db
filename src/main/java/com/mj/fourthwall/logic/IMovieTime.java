package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.MovieTimeParamsTO;
import com.mj.fourthwall.logic.to.MovieTimeResultTO;

public interface IMovieTime {

    MovieTimeResultTO movieTime(MovieTimeParamsTO paramsTO);
}

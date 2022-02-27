package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.MovieDetailsParamsTO;
import com.mj.fourthwall.logic.to.MovieDetailsResultTO;

public interface IMovieDetails {

    MovieDetailsResultTO movieDetails(MovieDetailsParamsTO paramsTO);
}

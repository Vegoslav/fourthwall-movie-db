package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.MovieTimeParamsTO;
import com.mj.fourthwall.logic.to.MovieTimeResultTO;
import org.springframework.stereotype.Component;

@Component
public class MovieTimeLogic implements IMovieTime{

    @Override
    public MovieTimeResultTO movieTime(MovieTimeParamsTO paramsTO) {
        return null;
    }
}

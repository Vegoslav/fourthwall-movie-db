package com.mj.fourthwall.logic;

import com.mj.fourthwall.logic.to.MovieUpdateParamsTO;
import com.mj.fourthwall.logic.to.MovieUpdateResultTO;
import org.springframework.stereotype.Component;

@Component
public class MovieUpdateLogic implements IUpdateMovie{

    @Override
    public MovieUpdateResultTO updateMovie(MovieUpdateParamsTO paramsTO) {
        return null;
    }
}

package com.mj.fourthwall.webservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mj.fourthwall.webservice.to.OMDBMovieTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OMDBAPIServiceTest {

    @Test
    public void testGetAMovie() throws JsonProcessingException {
        OMDBAPIService omdbapiService = new OMDBAPIService();
        OMDBMovieTO movie = omdbapiService.getMovieDetails("tt0232500");

        Assertions.assertEquals("tt0232500", movie.getImdbID());

    }
}
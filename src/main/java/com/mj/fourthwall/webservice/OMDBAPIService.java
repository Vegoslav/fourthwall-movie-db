package com.mj.fourthwall.webservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mj.fourthwall.webservice.to.OMDBMovieTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OMDBAPIService {

    public OMDBMovieTO getMovieDetails(String omdbId) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String apiKey = System.getenv("OMDBKEY");

        String omdbResource = "http://www.omdbapi.com/?apikey="+apiKey+"&i=";
        ResponseEntity<String> response = restTemplate.getForEntity(omdbResource + omdbId, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        OMDBMovieTO omdbMovieTO = objectMapper.readValue(response.getBody(), OMDBMovieTO.class);

        return omdbMovieTO;
    }
}

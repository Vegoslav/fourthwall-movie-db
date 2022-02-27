package com.mj.fourthwall.controller.to;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = MovieDetailsResponseTO.MovieDetailsResponseTOBuilder.class)
public class MovieDetailsResponseTO {

    Long id;
    String title;
    String year;
    String genre;
    String rated;
    String released;
    String actors;
    String country;
    String language;
    String metascore;

    @JsonPOJOBuilder
    public static final class MovieDetailsResponseTOBuilder{

    }


}

package com.mj.fourthwall.webservice.to;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = OMDBMovieTO.OMDBMovieTOBuilder.class)
public class OMDBMovieTO {
    String title;
    String year;
    String rated;
    String released;
    String runtime;
    String genre;
    String director;
    String writer;
    String actors;
    String plot;
    String language;
    String country;
    String awards;
    String poster;
    List<RatingTO> ratings;
    String metascore;
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String type;
    String dvd;
    String boxOffice;
    String production;
    String website;
    String response;

    @JsonPOJOBuilder(withPrefix = "")
    public static class OMDBMovieTOBuilder{};
}

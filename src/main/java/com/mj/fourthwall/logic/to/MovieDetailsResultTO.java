package com.mj.fourthwall.logic.to;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieDetailsResultTO {

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
    Boolean found;

}

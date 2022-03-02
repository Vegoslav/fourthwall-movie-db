package com.mj.fourthwall.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Builder
@Data
@RedisHash("Movie")
public class Movie {

    @Id
    private String id;
    private String title;
    private Double rate;
    private Integer votes;
    private Integer hours;
    private Integer minutes;
}

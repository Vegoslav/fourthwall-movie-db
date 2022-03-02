package com.mj.fourthwall.db.repository;

import com.mj.fourthwall.MovieDbApplication;
import com.mj.fourthwall.db.configuration.DatabaseConfiguration;
import com.mj.fourthwall.db.entity.Movie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.embedded.RedisServerBuilder;

import java.io.IOException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MovieDbApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestPropertySource(properties = {
    "spring.redis.host= localhost",
    "spring.redis.port= 6380"
})
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private static redis.embedded.RedisServer redisServer;

    @Test
    public void testSaveAndGet()
    {
        Movie movie = Movie.builder().title("Fast and Furious").build();
        movie = movieRepository.save(movie);
        Optional<Movie> byId = movieRepository.findById(movie.getId());

        Assertions.assertTrue(byId.isPresent());
        Assertions.assertEquals(movie.getTitle(), byId.get().getTitle());
    }
}
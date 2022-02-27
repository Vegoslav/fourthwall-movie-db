package com.mj.fourthwall.db.repository;

import com.mj.fourthwall.db.configuration.DatabaseConfiguration;
import com.mj.fourthwall.db.entity.Movie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.embedded.RedisServerBuilder;

import java.io.IOException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private static redis.embedded.RedisServer redisServer;

    @BeforeAll
    public static void startRedisServer() throws IOException {
        redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 128M").build();
        redisServer.start();
    }

    @AfterAll
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }

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
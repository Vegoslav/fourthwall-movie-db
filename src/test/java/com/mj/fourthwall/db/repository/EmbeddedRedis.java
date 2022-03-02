package com.mj.fourthwall.db.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

import java.io.IOException;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class EmbeddedRedis {

    @Value("${spring.redis.host}")
    private String hostname;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisServerBean redisServer() throws IOException {
        return new RedisServerBean();
    }

    class RedisServerBean implements InitializingBean, DisposableBean{

        private RedisServer redisServer;

        @Override
        public void destroy() throws Exception {
            if(redisServer != null) {
                redisServer.stop();
            }
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            redisServer = new RedisServerBuilder().port(port).setting("maxmemory 128M").build();
            redisServer.start();
        }
    }

}

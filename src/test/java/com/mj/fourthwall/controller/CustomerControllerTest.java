package com.mj.fourthwall.controller;

import com.mj.fourthwall.MovieDbApplication;
import com.mj.fourthwall.controller.to.RateMovieRequestTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = MovieDbApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerController customerController;

    @Test
    public void testRateMovie() throws Exception {
        RateMovieRequestTO request = new RateMovieRequestTO(2);

        mvc.perform(MockMvcRequestBuilders.post("/movie/15/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testMovieDetails() throws Exception {
        mvc.perform(get("/movie/15/details")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testMovieTime() throws Exception {
        mvc.perform(get("/movie/15/time")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
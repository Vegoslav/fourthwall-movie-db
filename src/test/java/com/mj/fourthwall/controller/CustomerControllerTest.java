package com.mj.fourthwall.controller;

import com.mj.fourthwall.DBInitializer;
import com.mj.fourthwall.MovieDbApplication;
import com.mj.fourthwall.controller.to.RateMovieRequestTO;
import com.mj.fourthwall.logic.IMovieDetails;
import com.mj.fourthwall.logic.IMovieTime;
import com.mj.fourthwall.logic.IRateMovie;
import com.mj.fourthwall.logic.to.MovieDetailsResultTO;
import com.mj.fourthwall.logic.to.MovieTimeResultTO;
import com.mj.fourthwall.logic.to.RateMovieResultTO;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = CustomerController.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IMovieTime movieTime;
    @MockBean
    private IRateMovie rateMovie;
    @MockBean
    private IMovieDetails movieDetails;

    @Autowired
    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void beforeEach()
    {
        Mockito.when(movieTime.movieTime(Mockito.any())).thenReturn(new MovieTimeResultTO(15, 30, true));
        Mockito.when(rateMovie.rateMovie(Mockito.any())).thenReturn(new RateMovieResultTO(true));
        Mockito.when(movieDetails.movieDetails(Mockito.any())).thenReturn(MovieDetailsResultTO.builder().id(15L).title("Fast and Furious").build());
    }

    @Test
    public void testRateMovie() throws Exception {
        RateMovieRequestTO request = new RateMovieRequestTO(2);

        mvc.perform(MockMvcRequestBuilders.post("/movie/15/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("rated", Matchers.is(true)));

    }

    @Test
    public void testMovieDetails() throws Exception {
        mvc.perform(get("/movie/15")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title", Matchers.is("Fast and Furious")));
    }

    @Test
    public void testMovieTime() throws Exception {
        mvc.perform(get("/movie/15/time")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("hour", Matchers.is(15)))
                .andExpect(jsonPath("minutes", Matchers.is(30)));
    }

}
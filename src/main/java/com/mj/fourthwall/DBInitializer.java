package com.mj.fourthwall;

import com.mj.fourthwall.db.entity.Movie;
import com.mj.fourthwall.db.repository.MovieRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DBInitializer {

    private final MovieRepository movieRepository;

    public DBInitializer(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
        init();
    }

    private void init(){
        movieRepository.deleteAll();

        List<Movie> movies = new LinkedList<>();
        movies.add(new Movie(null, "tt0232500", "The Fast and the Furious", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt0322259", "2 Fast 2 Furious", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt0463985", "The Fast and the Furious: Tokyo Drift", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt1013752", "Fast & Furious", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt1596343", "Fast Five", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt1905041", "Fast & Furious 6", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt2820852", "Furious 7", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt4630562", "The Fate of the Furious", 0.0, 0, 9, 0));
        movies.add(new Movie(null, "tt5433138", "F9: The Fast Saga", 0.0, 0, 9, 0));

        movieRepository.saveAll(movies);
    }
}

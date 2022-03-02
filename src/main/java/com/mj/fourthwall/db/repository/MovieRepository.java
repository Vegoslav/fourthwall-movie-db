package com.mj.fourthwall.db.repository;

import com.mj.fourthwall.db.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String> {
}

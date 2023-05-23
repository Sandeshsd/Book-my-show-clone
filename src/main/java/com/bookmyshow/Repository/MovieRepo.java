package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie , Long>{

}

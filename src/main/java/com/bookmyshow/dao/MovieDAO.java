package com.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.Repository.MovieRepo;
import com.bookmyshow.entity.Movie;

@Repository
public class MovieDAO {

	@Autowired
	private MovieRepo movieRepo;
	
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	public Movie getMovieById(long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
			if(optional.isEmpty()) {
				return null;
			}
			return optional.get();
	}
	public Movie deleteMovieById(long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
		if(optional.isEmpty()) {
			return null;
		}
		movieRepo.delete(optional.get());
		return optional.get();
	}
	public Movie updateMovie(Movie movie,long movieId) {
		Optional<Movie> optional=movieRepo.findById(movieId);
		if(optional.isPresent()) {
			movie.setMovieId(movieId);
			return movieRepo.save(movie);
		}
		return null;
	}
}

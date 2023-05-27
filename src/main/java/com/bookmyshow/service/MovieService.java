package com.bookmyshow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.MovieDAO;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.exception.MovieNotFoundByIdException;
import com.bookmyshow.util.responseStructure;

@Service
public class MovieService {

	@Autowired
	private MovieDAO dao;
	
	public ResponseEntity<responseStructure<Movie>> saveMovie(Movie movie){
		Movie movie2=dao.saveMovie(movie);
		
		responseStructure<Movie> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("movie added successfully");
		responseStructure.setData(movie2);
		
		return new ResponseEntity<responseStructure<Movie>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<responseStructure<Movie>> getMovieById(long movieId){
		Movie movie=dao.getMovieById(movieId);
		if(movie!=null) {
			responseStructure<Movie> responseStructure=new responseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("movie fetched successfully");
			responseStructure.setData(movie);
			return new ResponseEntity<responseStructure<Movie>>(responseStructure,HttpStatus.OK);
		}
		throw new MovieNotFoundByIdException("plz enter crct movie id");
	}
	public ResponseEntity<responseStructure<Movie>> deleteMovieById(long movieId) {
		Movie movie=dao.getMovieById(movieId);
		if(movie== null) {
			throw new MovieNotFoundByIdException("plz enter crct movie id");
		}
		responseStructure<Movie> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("movie deleted successfully");
		responseStructure.setData(movie);
		return new ResponseEntity<responseStructure<Movie>>(responseStructure,HttpStatus.FOUND);
	}
}

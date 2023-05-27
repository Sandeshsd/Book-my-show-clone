package com.bookmyshow.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;
import com.bookmyshow.util.responseStructure;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public ResponseEntity<responseStructure<Movie>> saveMovie(@Valid @RequestBody Movie movie){
		return movieService.saveMovie(movie);
	}
	@GetMapping
	public ResponseEntity<responseStructure<Movie>> getMovieById(@RequestParam long movieId){
		return movieService.getMovieById(movieId);
	}
	@DeleteMapping
	public ResponseEntity<responseStructure<Movie>> deleteMovieById(@RequestParam long movieId){
		return movieService.deleteMovieById(movieId);
	}
}

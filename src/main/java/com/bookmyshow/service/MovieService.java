package com.bookmyshow.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.MovieDAO;
import com.bookmyshow.dao.ProductionHouseDAO;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.ProductionHouse;
import com.bookmyshow.exception.MovieNotFoundByIdException;
import com.bookmyshow.exception.ProductionHouseNotFoundByIdException;
import com.bookmyshow.util.responseStructure;

@Service
public class MovieService {

	@Autowired
	private MovieDAO dao;
	
	@Autowired
	private ProductionHouseDAO productionDao;
	
	public ResponseEntity<responseStructure<Movie>> saveMovie(Movie movie,long productionId){
		ProductionHouse house=productionDao.getProductionHouseById(productionId);
		if(house!=null) {
			Movie movie2=dao.saveMovie(movie);
		movie.setProductionHouse(house);
		house.getMovies().add(movie2);
		responseStructure<Movie> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("movie added successfully");
		responseStructure.setData(movie2);
		 List<Movie> list=new ArrayList<Movie>();
		   list.add(movie2);
		   productionDao.updateProductionHouse(house, productionId);
		
		return new ResponseEntity<responseStructure<Movie>>(responseStructure,HttpStatus.CREATED);
		}
		throw new ProductionHouseNotFoundByIdException("failed to add movie");
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
	public ResponseEntity<responseStructure<Movie>> updateMovie(Movie movie,long movieId){
		ProductionHouse house=productionDao.getProductionHouseById(movieId);
		movie=dao.getMovieById(movieId);
		if(movie!=null) {
			return null;
		}
		return null;
	}
}

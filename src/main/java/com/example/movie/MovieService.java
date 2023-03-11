package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    int updatedMovieId = 6;
    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    @Override
    public ArrayList<Movie> getMovies(){
        Collection<Movie> moviesCollection = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(moviesCollection);

        return movies;
    }

    @Override
    public Movie getMovieById(int movieId){
        Movie movie = movieList.get(movieId);

        if(movie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return movie;

    }

    @Override
    public Movie addMovie(Movie movie){
        movie.setMovieId(updatedMovieId);

        movieList.put(updatedMovieId, movie);
        Movie savedMovie = movieList.get(updatedMovieId);

        updatedMovieId += 1;

        return savedMovie;


    }

    @Override
    public Movie updateMovie(int movieId, Movie movie){
        Movie existingMovie = movieList.get(movieId);

        if(existingMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(movie.getMovieId() != 0){
            existingMovie.setMovieId(movie.getMovieId());
        }

        if(movie.getMovieName() != null){
            existingMovie.setMovieName(movie.getMovieName());
        }

        if(movie.getLeadActor() != null){
            existingMovie.setLeadActor(movie.getLeadActor());
        }

        return existingMovie;
    }

    @Override 
    public void deleteMovie(int movieId){
        Movie movie = movieList.get(movieId);

        if(movie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}

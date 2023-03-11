package com.example.movie;


public class Movie{
    private int movieId;
    private String movieName;
    private String leadActor;

    public Movie(int movieId, String movieName, String leadActor){
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    public int getMovieId(){ //GETTER
        return this.movieId;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public String getMovieName(){ //GETTER
        return this.movieName;
    }

    public void setLeadActor(String leadActor){
        this.leadActor = leadActor;
    }

    public String getLeadActor(){ //GETTER
        return this.leadActor;
    }

}
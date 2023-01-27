package com.driver;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    MovieRepository mr;

    MovieService() {
        mr = new MovieRepository();
    }

    public void addMovie(Movie movie) {
        mr.movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        mr.directorMap.put(director.getName(), director);
    }

    public void makeMovieDirectorPair(String movieName, String directorName) {
        if(mr.moviesByDirectorMap.containsKey(directorName)) {
            List<String> list = mr.moviesByDirectorMap.get(directorName);
            list.add(movieName);
        } else {
            List<String> list = new ArrayList<>();
            list.add(movieName);
            mr.moviesByDirectorMap.put(directorName, list);
        }
    }

    public Movie getMovie(String movieName) {
        if(mr.movieMap.containsKey(movieName)) return mr.movieMap.get(movieName);
        return null;
    }

    public Director getDirector(String directorName) {
        if(mr.directorMap.containsKey(directorName)) return mr.directorMap.get(directorName);
        return null;
    }

    public List<String> getMoviesByDirector(String directorName) {
        List<String> movies = new ArrayList<>();
        if(mr.moviesByDirectorMap.containsKey(directorName))
            for (String movieName: mr.moviesByDirectorMap.get(directorName)) {
                movies.add(mr.movieMap.get(movieName).getName());
            }
        return movies;
    }

    public List<String> getAllMovies() {
        List<String> movies = new ArrayList<>();
        for (String movieName: mr.movieMap.keySet()) {
            movies.add(mr.movieMap.get(movieName).getName());
        }
        return movies;
    }

    public void deleteDirector(String directorName) {
        if(mr.directorMap.containsKey(directorName))
            mr.directorMap.remove(directorName);
        if(mr.moviesByDirectorMap.containsKey(directorName)) {
            for (String movieName : mr.moviesByDirectorMap.get(directorName))
                mr.movieMap.remove(movieName);
            mr.moviesByDirectorMap.remove(directorName);
        }
    }

    public void deleteAllDirectors() {
        for (String directorName: mr.directorMap.keySet())
            deleteDirector(directorName);
    }
}

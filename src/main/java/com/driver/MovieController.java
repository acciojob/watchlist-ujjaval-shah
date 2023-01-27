package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    MovieService ms;

    MovieController() {
        ms = new MovieService();
    }

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        ms.addMovie(movie);
        return new ResponseEntity("success", HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        ms.addDirector(director);
        return new ResponseEntity("success", HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie name") String movieName, @RequestParam("director name") String directorName) {
        ms.makeMovieDirectorPair(movieName, directorName);
        return new ResponseEntity("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) {
        return new ResponseEntity(ms.getMovie(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name) {
        return new ResponseEntity(ms.getDirector(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("name") String name) {
        return new ResponseEntity(ms.getMoviesByDirector(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies() {
        return new ResponseEntity(ms.getAllMovies(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director name") String directorName) {
        ms.deleteDirector(directorName);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        ms.deleteAllDirectors();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

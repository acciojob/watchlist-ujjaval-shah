package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    Map<String, Movie> movieMap;
    Map<String, Director> directorMap;
    Map<String, List<String>> moviesByDirectorMap;

    MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.moviesByDirectorMap = new HashMap<>();
    }
}

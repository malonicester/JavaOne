package org.java.ticketbooking.service.impl;

import org.java.ticketbooking.models.Movie;
import org.java.ticketbooking.service.Context;
import org.java.ticketbooking.service.MovieService;

import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    @Override
    public void createMovie(String title, Double durationInMinutes) {
        if (Context.MOVIES.containsKey(title)) {
            throw new IllegalArgumentException("Movie with Title " + title + " already exists.");
        }
        boolean defaultDuration = durationInMinutes == null || durationInMinutes < 0;
        Movie movie = defaultDuration ? new Movie(title) : new Movie(title, durationInMinutes);
        Context.MOVIES.put(movie.getId(), movie);

    }

    @Override
    public Movie getMovie(String id) {
        return Optional.ofNullable(Context.MOVIES.get(id)).orElseThrow(() -> new IllegalArgumentException("Movie with id " + id + " does not exists."));
    }

}

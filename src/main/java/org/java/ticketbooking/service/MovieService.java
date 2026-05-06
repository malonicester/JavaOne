package org.java.ticketbooking.service;

import org.java.ticketbooking.models.Movie;

public interface MovieService {
    void createMovie(String title, Double durationInMinutes);
    Movie getMovie(String id);
}

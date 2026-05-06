package org.java.ticketbooking.models;

import java.util.UUID;

public class Movie {
    private final String title;
    private final String id;
    private double durationInMinutes;

    public Movie(String title,double durationInMinutes) {
        this.title = title;
        this.id = UUID.randomUUID().toString();
        this.durationInMinutes = durationInMinutes;
    }

    public Movie(String title) {
       this(title, 120);
    }

    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }
}

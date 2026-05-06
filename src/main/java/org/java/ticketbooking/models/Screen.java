package org.java.ticketbooking.models;

import java.util.Map;

public class Screen {

    private final Theater theater;
    private final Map<Character, Seat[]> seats;
    private final int capacityPerRows;
    private final int rows;
    private Movie movie;

    public Screen(Theater theater,int capacity) {
        this.theater = theater;
        this.capacityPerRows = capacity;
        rows = 15;
        this.seats = initializeSeats(rows,capacityPerRows);
    }
    public Screen(Theater theater, int capacity, int rows) {
        if (rows < 1 || rows > 26) {
            throw new IllegalArgumentException("Rows must be between 1 and 26");
        }
        this.theater = theater;
        this.capacityPerRows = capacity;
        this.rows = rows;
        this.seats = initializeSeats(rows,capacityPerRows);
    }

    public Screen(Theater theater, int capacity, int rows,Movie movie) {
       this(theater, capacity, rows);
       this.movie = movie;
    }

    private Map<Character, Seat[]> initializeSeats(int rows,int capacityPerRows) {
        Map<Character, Seat[]> seatMap = new java.util.HashMap<>();
        for (char row = 'A'; row < 'A' + rows; row++) {
            Seat[] rowSeats = new Seat[capacityPerRows];
            for (int i = 0; i < capacityPerRows; i++) {
                rowSeats[i] = new Seat(i + 1,theater, this);
            }
            seatMap.put(row, rowSeats);
        }
        return seatMap;
    }

    public Theater getTheater() {
        return theater;
    }

    public Map<Character, Seat[]> getSeats() {
        return Map.copyOf(seats);
    }

    public int getCapacityPerRows() {
        return capacityPerRows;
    }

    public int getRows() {
        return rows;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

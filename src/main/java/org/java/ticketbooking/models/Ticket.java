package org.java.ticketbooking.models;

import java.util.Date;
import java.util.Set;

public class Ticket {
    private String id;
    private Theater theater;
    private Screen screen;
    private Set<Seat> seats;
    private User user;
    private Date date;
    private Movie movie;
}

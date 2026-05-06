package org.java.ticketbooking.models;

import java.util.Date;
import java.util.UUID;


public class SeatInCart {
    private final String id;
    private final Date enteredTime;
    private final Seat seat;
    private final User user;

    public Date getEnteredTime() {
        return enteredTime;
    }

    public SeatInCart(Seat seat, User user) {
        this.id = UUID.randomUUID().toString();
        this.seat = seat;
        this.user = user;
        enteredTime = new Date();
    }

    public Seat getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }
}

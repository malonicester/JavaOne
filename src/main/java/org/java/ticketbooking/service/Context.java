package org.java.ticketbooking.service;

import org.java.ticketbooking.models.*;

import java.util.HashMap;
import java.util.Map;

public interface Context {
    Map<String, Movie> MOVIES = new HashMap<>();
    Map<String, User> USERS = new HashMap<>();
    Map<String, Theater> THEATERS = new HashMap<>();
    Map<String, Screen> SCREENS = new HashMap<>();
    Map<String, Ticket> TICKETS = new HashMap<>();
}

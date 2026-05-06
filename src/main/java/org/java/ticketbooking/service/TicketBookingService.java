package org.java.ticketbooking.service;

import org.java.ticketbooking.dto.TicketBookingRequest;
import org.java.ticketbooking.dto.TicketBookingResponse;

public interface TicketBookingService {
    public TicketBookingResponse bookTicket(TicketBookingRequest request);
}

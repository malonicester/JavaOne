package org.java.ticketbooking.dto;

import org.java.ticketbooking.models.BookingStatus;

public class TicketBookingResponse {
    private String userId;
    private String theatreName;
    private String screenName;
    private String movieName;
    private String bookingId;
    private String[] seatNumbers;
    private BookingStatus bookingStatus;

    public String getUserId() {
        return userId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder {
        private String userId;
        private String theatreName;
        private String screenName;
        private String movieName;
        private String bookingId;
        private String[] seatNumbers;
        private BookingStatus bookingStatus;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTheatreName(String theatreName) {
            this.theatreName = theatreName;
            return this;
        }

        public Builder setScreenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public Builder setMovieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setSeatNumbers(String[] seatNumbers) {
            this.seatNumbers = seatNumbers;
            return this;
        }

        public Builder setBookingStatus(BookingStatus bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public TicketBookingResponse build() {
            TicketBookingResponse response = new TicketBookingResponse();
            response.userId = this.userId;
            response.theatreName = this.theatreName;
            response.screenName = this.screenName;
            response.movieName = this.movieName;
            response.bookingId = this.bookingId;
            response.seatNumbers = this.seatNumbers;
            response.bookingStatus = this.bookingStatus;
            return response;
        }
    }
}

package org.java.ticketbooking.dto;


import java.util.Objects;

public class TicketBookingRequest {
    private String userId;
    private String theaterId;
    private String showId;
    private String[] seatIds;

    private TicketBookingRequest() {}

    public static Builder builder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getShowId() {
        return showId;
    }

    public String[] getSeatIds() {
        return seatIds;
    }

    private static class Builder  {
        private String userId;
        private String theaterId;
        private String showId;
        private String[] seatIds;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTheaterId(String theaterId) {
            this.theaterId = theaterId;
            return this;
        }

        public Builder setShowId(String showId) {
            this.showId = showId;
            return this;
        }

        public Builder setSeatIds(String[] seatIds) {
            this.seatIds = seatIds;
            return this;
        }

        public TicketBookingRequest build() {
            Objects.requireNonNull(userId, "User ID cannot be null");
            Objects.requireNonNull(theaterId, "Theater ID cannot be null");
            Objects.requireNonNull(showId, "Show ID cannot be null");
            if (seatIds == null || seatIds.length == 0) {
                throw new IllegalArgumentException("Seat IDs cannot be null or empty");
            }
            for (String seatId : seatIds) {
                if (seatId == null || seatId.isBlank()) {
                    throw new IllegalArgumentException("Seat ID cannot be null or blank");
                }
                if(!seatId.matches("^[A-Z]-\\d{2}$")) {
                    throw new IllegalArgumentException("Invalid seat ID format: " + seatId);
                }
            }
            TicketBookingRequest request = new TicketBookingRequest();
            request.userId = this.userId;
            request.theaterId = this.theaterId;
            request.showId = this.showId;
            request.seatIds = this.seatIds;
            return request;
        }
    }
}

package org.java.ticketbooking.models;

import java.time.LocalDateTime;
import java.util.Map;

public class Show {
    private String showId;
    private Movie movie;
    private Screen screen;
    private Map<Character, Seat[]> seats;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Show() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Map<Character, Seat[]> getSeats() {
        return Map.copyOf(seats);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder {
        private Movie movie;
        private Screen screen;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private Map<Character, Seat[]> seats;
        public Builder movie(Movie movie) {
            this.movie = movie;
            return this;
        }
        public Builder screen(Screen screen) {
            this.screen = screen;
            return this;
        }
        public Builder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }
        public Builder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }
        public Show build() {
            Show show = new Show();
            show.movie = this.movie;
            show.screen = this.screen;
            show.seats = this.screen.getSeats();
            show.startTime = this.startTime;
            show.endTime = this.endTime;
            return show;
        }
    }

    public static void main(String[] args) {
        Show show = Show.builder()
                .movie(new Movie("Inception"))
                .screen(new Screen(new Theater("Cineplex"), 200))
                .startTime(LocalDateTime.of(2023, 10, 1, 18, 0))
                .endTime(LocalDateTime.of(2023, 10, 1, 20, 28))
                .build();

    }
}

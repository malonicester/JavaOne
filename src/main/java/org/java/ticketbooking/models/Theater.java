package org.java.ticketbooking.models;

import java.util.Objects;
import java.util.UUID;

public class Theater {
    private final String id;
    private String name;

    public Theater(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Theater theater = (Theater) o;
        return Objects.equals(id, theater.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

package org.java.practice.Repository;

import org.java.lld.entities.BaseEntity;

public class User extends BaseEntity<Long> {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "name = " + this.name;
    }
}

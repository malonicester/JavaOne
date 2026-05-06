package org.java.practice;

public abstract class BaseEntity <ID>{
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}

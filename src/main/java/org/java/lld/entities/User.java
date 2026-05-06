package org.java.lld.entities;

public class User extends BaseEntity<Long>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "id= " + super.getId()+
                '}';
    }
}

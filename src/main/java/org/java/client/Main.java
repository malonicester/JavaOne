package org.java.client;

public class Main {
    public static void main(String[] args) {
        HttpRequest<String> build = HttpRequest.<String>builder().body("").url("").build();
    }
}

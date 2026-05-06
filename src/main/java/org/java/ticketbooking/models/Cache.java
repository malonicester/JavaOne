package org.java.ticketbooking.models;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cache {

    private static Cache INSTANCE;

    private final Map<String,SeatInCart> CACHE;

    private Cache(){
        CACHE = new ConcurrentHashMap<>();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            CACHE.entrySet().removeIf(entry ->
                    ChronoUnit.MINUTES.between(entry.getValue().getEnteredTime().toInstant(), new Date().toInstant()) >= 10
            );
        }, 0, 1, TimeUnit.MINUTES);
    }

    public static Cache getInstance() {
        if(INSTANCE == null) {
            synchronized (Cache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Cache();
                }
            }
        }
        return INSTANCE;
    }


    public void put(String key, SeatInCart value) {
        CACHE.put(key, value);
    }

    public Object get(String key) {
        return CACHE.get(key);
    }

    public boolean containsKey(String key) {
        return CACHE.containsKey(key);
    }

}

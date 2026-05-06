package org.java;

public class SingleTon {
    private static  SingleTon INSTANCE = null;

    private SingleTon readResolve(){
        return INSTANCE;
    }
    private SingleTon(){}

    public static SingleTon getInstance(){
        if(INSTANCE == null) {
            synchronized (INSTANCE) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTon();
                }
            }
        }
        return INSTANCE;
    }
}

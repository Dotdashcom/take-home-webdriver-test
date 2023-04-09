package com.internet.utilities;

public class SingletonCache {

    private static SingletonCache INSTANCE;
    public int requestIdHolder = -1;
    
    private SingletonCache() {        
    }
    
    public static SingletonCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonCache();
        } 
        return INSTANCE;
    }
}

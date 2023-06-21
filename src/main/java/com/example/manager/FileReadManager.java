package com.example.manager;

import com.example.utils.ReadProperties;

public class FileReadManager {
    private static FileReadManager fileReadManager = new FileReadManager();
    private static ReadProperties readProperties;

    private FileReadManager(){

    }

    public static FileReadManager getInstance(){
        return fileReadManager;
    }

    public ReadProperties getReadProperties(){
        return (readProperties == null) ? new ReadProperties() : readProperties;
    }
}

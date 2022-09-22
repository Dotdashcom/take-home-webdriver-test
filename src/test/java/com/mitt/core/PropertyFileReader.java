package com.mitt.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyFileReader {

    private final Properties properties = new Properties();

    private PropertyFileReader()
    {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        System.out.println("Reading properties from the file");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class LazyHolder
    {
        private static final PropertyFileReader INSTANCE = new PropertyFileReader();
    }

    public static PropertyFileReader getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Set<String> getAllPropertyNames(){
        return properties.stringPropertyNames();
    }

    public boolean containsKey(String key){
        return properties.containsKey(key);
    }
}

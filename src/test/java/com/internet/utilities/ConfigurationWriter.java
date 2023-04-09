package com.internet.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationWriter {

    public void write(String Value,String Key){
        Properties properties = new Properties();
        String path = System.getProperty("user.dir")+"/config.properties";

        try(OutputStream outputStream = new FileOutputStream(path)){
            properties.setProperty(Value,Key);
            properties.store(outputStream, null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}




package com.interview.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //In this class we will implement the repeated steps of reading
    //from configuration.properties file

    //create one utility method that is reading from configuration.properties
    //#1-creat the object of Properties
    private  static Properties properties=new Properties();
    static {
        //1==>if I don't creat I can't write anything
        //2==>important thing must happen before everything else
        //#2 Get the path and open the file
        //String path="configuration.properties";

        try {
            //opening the memory formJVM memory
            FileInputStream   file = new FileInputStream("configuration.properties");//copy path from content root
            //#3-load the opened file into the Properties object
            properties.load(file);

            //closing the file in JVM Memory
            file.close();





        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //#4-use the object to read from the configuration.properties file
    public static String getProperty(String keyWord){ return properties.getProperty(keyWord);}
}

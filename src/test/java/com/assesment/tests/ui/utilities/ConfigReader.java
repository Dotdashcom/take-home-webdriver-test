package com.assesment.tests.ui.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    /**This class is used to read configuration.properties file*/

    //Create Properties object
    private static Properties properties;

    //static block is executed first
    static{
        String path ="config.properties";
        try {
            //opening the file
            FileInputStream fileInputStream = new FileInputStream(path);
            //instantiated the properties object
            properties = new Properties();
            //Loading the file
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//ending the static block

    //Writing the method
    //it will take key as String
    //and return the value
    //getProperty("app_url"); ==> http://www.carettahotel.com/


    public static String getProperty(String key){

        String value = properties.getProperty(key);
        return value;

//        return properties.getProperty(key);
    }

}


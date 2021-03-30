package com.DotDash.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
    // Properties Class
    Properties pro;

    // Constructor
    public ReadConfig()
    {
        File src = new File("./Config.properties");
        // Creating File object
        try
        {
            // Open FileInputStream and Read data
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis); // Load config.properties file
        }
        catch (Exception e)
        {
            // If config.properties file is not available it will throw an exception
            System.out.println("Exception is " + e.getMessage());
        }
    }

    // Methods to read data from config.properties
    public String getAppURL()                            // ok - add new url in config.properties
    {
        String url=pro.getProperty("baseURL"); // Value from config.properties stored in url variable
        return url;
    }
    public String getUsername() // new
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }
}
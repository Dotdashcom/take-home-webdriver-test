package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig(){
        File file = new File("./src/main/resources/configuration/config.properties");
        try{
            //Fetch config.properties file data
            FileInputStream fileInput = new FileInputStream(file);
            prop = new Properties();
            prop.load(fileInput);
        }catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    //Methods to read data from Config.properties
    public String getBaseUrl(){
        return prop.getProperty("baseUrl");
    }

    public String getChromePath(){
        return prop.getProperty("chromePath");
    }



}

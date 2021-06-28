package utilities;


import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
      private static Properties properties;

    static {
        String path= "configuration.properties";
        try{
            // FileInputStream will open the file
            FileInputStream input=new FileInputStream(path);
            properties=new Properties();
            // load method will store every value from properties file to the Properties object
            properties.load(input);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }




}
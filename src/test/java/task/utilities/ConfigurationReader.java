package task.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        try (FileInputStream fileInputStream=new FileInputStream("configuration.properties")){
            properties =new Properties();
            properties.load(fileInputStream);

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Enable to find configuration.properties file!");

        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}

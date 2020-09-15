package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties props = new Properties();

    public ConfigReader(){

        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getConfiguration(String key) {
        return props.getProperty(key);
    }
}

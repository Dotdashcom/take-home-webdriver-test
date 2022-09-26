package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties config_File;

    static {
        try {
            String filePath = Constants.FILEPATH;
            FileInputStream input = new FileInputStream(filePath);
            config_File = new Properties();
            config_File.load(input);
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getInput(String key) {
        return config_File.getProperty(key);

    }

}

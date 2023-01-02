package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    static final String WORKING_DIR = System.getProperty("user.dir");
    static final String CONFIG_FILE_PATH = WORKING_DIR + "/src/resources/config.properties";

    public  String readDataFromPropertiesFiles(String propertyKey) throws IOException {
        Properties properties = propertyFileReader(CONFIG_FILE_PATH);
        return properties.getProperty(propertyKey);
    }

    public  Properties propertyFileReader(String configFile) throws IOException {
     FileInputStream fis = null;
     Properties prop = null;
        try{
            fis = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(fis);
        }
        catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(fis!=null)
               fis.close();
        }
        return prop;
    }

    public static String getBaseURL()  {
        try {
            return new PropertiesFileReader().readDataFromPropertiesFiles("baseURL");
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername() {
        try {
            return new PropertiesFileReader().readDataFromPropertiesFiles("loginUsername");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getPassword() {
        try {
            return new PropertiesFileReader().readDataFromPropertiesFiles("loginPassword");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

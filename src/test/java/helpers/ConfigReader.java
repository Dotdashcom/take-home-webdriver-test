package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader(){
        BufferedReader reader;
        String envFilePath = "env.properties";
        try {
            reader = new BufferedReader(new FileReader(envFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties fle not found at " + envFilePath);
        }
    }

    private String getProperty(String key){
        String property = properties.getProperty(key);
        if(property != null) return property;
        else throw new RuntimeException(key + " property not defined!");
    }

    public String getBaseURL(){
        return getProperty("baseURL");
    }

    public int getElementTimeout(){
        return Integer.parseInt(getProperty("elementTimeout"));
    }

    public String getValidUsername() {
        return getProperty("validUsername");
    }

    public String getValidPassword() {
        return getProperty("validPassword");
    }

    public String getLoginSuccessMessage() {
        return getProperty("loginSuccessMessage");
    }

    public String getLoginInvalidMessage() {
        return getProperty("loginInvalidMessage");
    }

    public String getLoginEndpoint() {
        return getProperty("loginEndpoint");
    }

    public String getDynamicLoadingEndpoint() {
        return getProperty("dynamicLoadingEndpoint");
    }

    public String getCheckboxEndpoint() {
        return getProperty("checkboxEndpoint");
    }

    public String getFloatingMenuEndpoint() {
        return getProperty("floatingMenuEndpoint");
    }

    public String getDynamicControlsEndpoint() {
        return getProperty("dynamicControlsEndpoint");
    }

    public String getDynamicContentEndpoint() {
        return getProperty("dynamicContentEndpoint");
    }

    public String getDropdownEndpoint() {
        return getProperty("dropdownEndpoint");
    }

    public String getDragAndDropEndpoint() {
        return getProperty("dragAndDropEndpoint");
    }

    public String getContextMenuEndpoint() {
        return getProperty("contextMenuEndpoint");
    }

    public String getContextAlertMessage() {
        return getProperty("contextAlertMessage");
    }
}


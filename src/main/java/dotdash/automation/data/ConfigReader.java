package dotdash.automation.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * Helps to load the files from config files
 */
public class ConfigReader {

    private String baseUri;
    private String username;
    private String password;
    private Properties props = null;
    private final HashMap<String, String> config = new HashMap();

    /**
     * Instantiate ConfigReader object with default props and load all properties into an HashMap
     */
    public ConfigReader() {
        loadPropertiesToMap();
        if (props != null) {
            this.baseUri = props.getProperty("baseUri");
            this.username = props.getProperty("username");
            this.password = props.getProperty("password");
        }
    }

    /**
     * Passing Property file name from System property and loading all properties into hashmap
     */
    public void loadPropertiesToMap() {
        String file = System.getProperty("dotdash.config");
        loadProperties(file);
    }

    /**
     * Passing Property file name from System property and loading all properties into hashmap
     *
     * @param file the file path for the properties file.
     */
    public void loadProperties(String file) {
        if (file == null || file.isEmpty()) {
            file = "config.properties";
        }
        Properties props = readPropertiesFile(file);
        if (props != null) {
            for (Map.Entry<Object, Object> x : props.entrySet()) {
                config.put((String) x.getKey(), (String) x.getValue());
            }
        }
    }

    /**
     * Gets the base uri from the property file.
     *
     * @return the base uri from the property file.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the base uri after the properties are loaded from the file. Note this will not change the actual property
     * file.
     *
     * @param baseUri the base uri to set for the properties.
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Gets the username from the property file.
     *
     * @return the username from the property file.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username after the properties are loaded from the file. Note this will not change the actual property
     * file.
     *
     * @param username the username to set for the properties.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password from the properties.
     *
     * @return the password in the properties.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password after the properties are loaded from the file. Note this will not change the actual property
     * file.
     *
     * @param password the password to set for the properties.
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Reads the properties from a file and returns the properties associated.
     *
     * @param fileName the file name for the file to be read.
     * @return the properties that were loaded from the file provided.
     */
    public Properties readPropertiesFile(String fileName) {
        try (FileInputStream is = new FileInputStream(
                new File(System.getProperty("user.dir") + File.separator + fileName))) {
            if (is != null) {
                props = new Properties();
                props.load(is);
            }

        } catch (IOException ex) {
            System.out.println("Oops... File is missing, Please check it: " + System.getProperty("user.dir") + File.separator + fileName);
            ex.printStackTrace();
        }
        return props;
    }

    /**
     * Get the value in the ConfigReader object that is associated with the provided key.
     *
     * @param key the key to the value that wants to be retrieved.
     * @return the value associated with this key.
     */
    public String getProperty(String key) {
        String value;
        try {
            value = config.get(key);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new RuntimeException("Request to the ConfigReader object was not successful.");
        }
        if (value == null) {
            throw new ConfigReaderPropertyNotFoundException("Key: " + key + " not found in the ConfigReader object. Verify the presence of key in the configuration file");
        }
        return value;
    }


    /**
     * Set Property value in hashmap with given key.
     *
     * @param key   the key that will be used later to retrieve the value provided.
     * @param value the value that will associated with the key provided.
     */
    public void setProperty(String key, String value) {
        config.put(key, value);
    }

}

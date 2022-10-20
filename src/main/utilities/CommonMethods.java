package src.main.utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

    public class CommonMethods {

        private static Properties browserProperties;
        private static Properties userUserDetails;

        private static String filePath;
        private static String userDetailsFilePath;

        public static void readAllProperties() {
             filePath = "resources\\data.properties.";
             userDetailsFilePath = "resources\\userdetails.config";
            browserProperties = readPropertyFile(filePath);
            userUserDetails = readPropertyFile(userDetailsFilePath);
        }

        private static Properties readPropertyFile(String filePath) {
            BufferedReader reader;
            Properties properties;
            try {
                reader = new BufferedReader(new FileReader(filePath));
                properties = new Properties();
                try {
                    properties.load(reader);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch ( FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("general.config not found at " + filePath);
            }
            return properties;
        }

        public static String getBrowserProperty(String property){
            return browserProperties.getProperty(property);
        }

        public static String getUserDetails(String property){
            return userUserDetails.getProperty(property);
        }


    }


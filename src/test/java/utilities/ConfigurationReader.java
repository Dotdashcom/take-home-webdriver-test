package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties configFile;

    static {
        try {
            String path = System.getProperty("user.dir")+"/configuration.properties";
            FileInputStream input = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public String getReportConfigPath(){
        String reportConfigPath = configFile.getProperty("reportConfigPath");
        if(reportConfigPath != null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static String getValue(String keyName){
        return configFile.getProperty(keyName);
    }


}

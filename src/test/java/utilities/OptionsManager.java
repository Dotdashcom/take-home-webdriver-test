package utilities;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OptionsManager {
    //Get Chrome Options

    public Properties prop;
    boolean headless;
    boolean start_maximized;
    boolean incognito;
    boolean ignore_errors;
    public void readProperties() throws IOException {
        String configFile = "./config/test.properties";
        FileInputStream stream = new FileInputStream(configFile);
        prop = new Properties();
        prop.load(stream);
        headless = Boolean.parseBoolean(prop.getProperty("headless"));
        start_maximized = Boolean.parseBoolean(prop.getProperty("start_maximized"));
        incognito = Boolean.parseBoolean(prop.getProperty("incognito"));
        ignore_errors = Boolean.parseBoolean(prop.getProperty("ignore_errors"));
        System.out.println("Setting headless: " + headless);
        System.out.println("Setting start_maximized: " + start_maximized);
        System.out.println("Setting incognito: " + incognito);
        System.out.println("Setting ignore_errors: " + ignore_errors);
    }
    public ChromeOptions getChromeOptions() throws IOException {
        readProperties();
        ChromeOptions options = new ChromeOptions();
        if(headless)
            options.addArguments("--headless");
        if(start_maximized)
            options.addArguments("--start-maximized");
        if(incognito)
            options.addArguments("--incognito");
        if(ignore_errors)
            options.addArguments("--ignore-certificate-errors");
        return options;
    }

}
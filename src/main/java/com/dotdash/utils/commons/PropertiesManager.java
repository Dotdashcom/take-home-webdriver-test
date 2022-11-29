package com.dotdash.utils.commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesManager {
    private static PropertiesManager instance;
    private static final Object lock = new Object();

    private static final Properties param = new Properties();
    private static final Logger logger = Logger.getLogger(PropertiesManager.class.getName());

    public static PropertiesManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertiesManager();
                instance.loadData();
            }
        }
        return instance;
    }


    private void loadData() {
        try {
            param.load(Files.newInputStream(Paths.get("src/main/resources/config.properties")));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Properties file not found", e);
        }
    }

    public String getProperty(String key) {
        return param.getProperty(key);
    }
}

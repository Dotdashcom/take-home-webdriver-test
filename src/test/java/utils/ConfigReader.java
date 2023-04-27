//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public ConfigReader() {
    }

    public static String readProperty(String key) {
        File file = new File("configuration.properties");
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }

        return properties.getProperty(key);
    }
}

package utilities;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationProp {
    private static final String CONFIGPATH = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(new InputStreamReader(Files.newInputStream(Paths.get(CONFIGPATH))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProp() {
        return prop;
    }
}

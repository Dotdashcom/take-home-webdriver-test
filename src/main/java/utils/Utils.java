package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Utils {
    public static String getDataFromConfig(String kayName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("src/main/resources/conf.yaml"));
        Yaml yaml = new Yaml();
        Map<String, Object> config = yaml.load(inputStream);
        String test_data = config.get(kayName).toString();
        return test_data;
    }
}

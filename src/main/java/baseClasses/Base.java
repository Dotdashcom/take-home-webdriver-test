package baseClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver = null;

    public static WebDriver initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static String readValue (String pathToValue) {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\data.json";
        JSONParser jsonParser = new JSONParser();
        String value = "";
        try {
            FileReader jsonFile = new FileReader(path);
            JSONObject data = (JSONObject) jsonParser.parse(jsonFile);
            String[] dataPath = pathToValue.split("\\.");
            switch (dataPath.length){
                case 2: {
                    JSONObject a = (JSONObject) data.get(dataPath[0]);
                    value = (String) a.get(dataPath[1]);
                    break;
                }
                case 3: {
                    JSONObject a = (JSONObject) data.get(dataPath[0]);
                    JSONObject b = (JSONObject) a.get(dataPath[1]);
                    value = (String) b.get(dataPath[2]);
                    break;
                }
                case 4: {
                    JSONObject a = (JSONObject) data.get(dataPath[0]);
                    JSONObject b = (JSONObject) a.get(dataPath[1]);
                    JSONObject c = (JSONObject) b.get(dataPath[2]);
                    value = (String) c.get(dataPath[3]);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
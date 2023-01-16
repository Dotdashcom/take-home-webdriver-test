package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReadingUtil {

  private static Properties prop = new Properties();

  static {
    String filePath = "src\\test\\resources\\configuration.properties";
    try {
      FileInputStream fileInputStream = new FileInputStream(filePath);
      prop.load(fileInputStream);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("File not found.");
    }
  }
  public static String getProperties(String keyword){
    return prop.getProperty(keyword);
  }


}

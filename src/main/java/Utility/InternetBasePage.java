package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;


public class InternetBasePage extends DriverFactory  {
	
	public static Properties loadProperties() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\config.properties");
		prop.load(file);
		return prop;
	}

}

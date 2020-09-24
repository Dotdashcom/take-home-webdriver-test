package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver driver;
	public Properties configProperties;
	protected static String propFilePath = System.getProperty("user.dir") + "/resources/config.properties";

	public BasePage(WebDriver driver) {
		this.driver = driver;
		configProperties = new Properties();

		try {
			configProperties.load(new FileInputStream(propFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}

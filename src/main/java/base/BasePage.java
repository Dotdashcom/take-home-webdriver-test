package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private static final int LONG_TIMEOUT=5000;
	public Properties configProperties;
	protected static String propFilePath = System.getProperty("user.dir") + "/resources/config.properties";
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver,LONG_TIMEOUT);
		PageFactory.initElements(driver, this);
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

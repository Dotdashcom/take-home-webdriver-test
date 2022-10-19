package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	private static FileInputStream file;
	protected static Properties prop;
	protected static WebDriver driver;
	private static Logger log = Logger.getLogger(BaseTest.class);
	protected static final int EXPLICIT_WAIT=500;
	protected static final int IMPLICIT_WAIT=1000;
	protected static Actions action;
	protected static Select select;
	protected static WebDriverWait wait;
	
	
	
	

	
	public BaseTest() {
		try {
		prop = new Properties();	
		file = new FileInputStream("S:\\take-home-webdriver-test\\src\\main\\java\\configurationpakage\\configuration.properties");
		prop.load(file);
	 }
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Configurations are not found; Restart the process or Check the program");
			
		}	
    }
	
	private static void get() {
		driver.get(prop.getProperty("url"));
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//webdriverwait
}
	
	public static void initiate() {
		if(prop.getProperty("browser").toString().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Connecting with Chrome Browser");
			get();
		}
		else if(prop.getProperty("browser").toString().equals("edge")) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
			log.info("Connecting with Edge Browser");
			get();
		}
	}
	
	public static void quitbrowser() {
		if(driver != null) {
		driver.quit();
		}
		else
		{
			driver.close();
		}
	}
}

package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseUtil;

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
		file = new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\take-home-webdriver-test\\src\\main\\java\\configurationpackage\\configuration.properties");
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
switch(prop.getProperty("type")){
		
		case "local":
			if(prop.getProperty("browser").equalsIgnoreCase(BaseUtil.Chrome.toString())) {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				log.info("Connecting with Chrome Browser");
			}
			else if(prop.getProperty("browser").equalsIgnoreCase(BaseUtil.Edge.toString())) {
				WebDriverManager.edgedriver().setup();
				//System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
				driver = new EdgeDriver();
				log.info("Connecting with Edge Browser");
			}
			else {
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
				log.info("Connecting with FireFox Browser");
			}
			break;
			
		case "remote":
	try {
		driver = RemoteDriverFactory.getRemoteWebDriver(prop.getProperty("browser"));
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
			break;
		}
		
		get();
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

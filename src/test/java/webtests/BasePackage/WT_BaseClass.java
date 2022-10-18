package webtests.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import webtests.utilities.WT_TimeUtils;

@Listeners(webtests.Reports.GenerateExtentReports.class)
public class WT_BaseClass {

	public static Properties pr =new Properties();
	public static WebDriver driver;	
	public static Logger logg;
	
	//Create Constructor
	public WT_BaseClass() {
		
		try {
			FileInputStream	file = new FileInputStream(System.getProperty("user.dir")
					+"\\src\\test\\java\\webtests\\environmentvariables\\Config.properties");
			 pr.load(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	    }

	@BeforeMethod 

	 //Create initial commands
	public void setup()  {
			String browsername = pr.getProperty("browser");
		
	if (browsername.equalsIgnoreCase("Firefox")) {
		System.out.println("Inside firefox");
		
		WebDriverManager.firefoxdriver().setup();
	
			logg.info("****Firefox browser opened****");
		}
	else if (browsername.equalsIgnoreCase("chrome")) {
			System.out.println("Inside chrome");
			
             ChromeOptions chromeOptions = new ChromeOptions();
             WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver(chromeOptions);
		
		//logg.info("Chrome browser opened");	
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(WT_TimeUtils.timepage,TimeUnit.SECONDS);
	 
	//log
		logg = Logger.getLogger("WebdriverTestsProject");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties");	
	}
	
	@AfterMethod
    public  void teardown() {
        driver.close();
        logg.info("****Browser Closed****");
	    }
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"//Screenshots//" +tname+ ".png");
		FileUtils.copyFile(source, target);
	
		logg.info("****Screenshot taken****");
	}	
	
}

package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDr {
	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException
	{
		 prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ivc17239adm\\git\\take-home-webdriver-test3\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
 
		if(browserName.equals("chrome"))
		{
 			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivc17239adm\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver= new ChromeDriver();
	}
		/*else if (browserName.equals("firefox"))
		{
			 driver= new FirefoxDriver();
			//firefox code
		}
		else if (browserName.equals("IE"))
		{
//			IE code
		}*/
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	return driver;

}
	
}

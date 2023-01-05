package basePack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static Properties props;
	public static WebDriver driver;
	
	
	public BaseClass() throws IOException
	{
		

		
		FileReader reader=new FileReader("F:\\Eclipse\\TASK\\configurationFiles\\config.properties");
		props=new Properties();
      props.load(reader);
		
 
		
	}
	
	
	public static void toIntialize(String endPoint) throws IOException, InterruptedException
	{
		

		
	
		String browserName=props.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			
			
			String URL = props.getProperty("URL");
			
			driver.get(URL+endPoint);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']//i")));
			
			
		}
		else
		{
			System.out.println("try with chrome browser");
		}
		
		
	}
}

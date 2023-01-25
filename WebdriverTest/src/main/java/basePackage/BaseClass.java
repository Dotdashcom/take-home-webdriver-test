package basePackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass {
	

	
	public static WebDriver driver;
	
	
	public static void initiation() {
			
    
    	 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	 	driver = new ChromeDriver();
    	
	}
     public static  void takeScreenshot(String fileName) {
    	 
    	 // take screenshot and store it as a file format:
    	 
    	  File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 
    	  // now copy the screenshot to desire location using copy file method:
    	  try {
    	  FileUtils.copyFile(file, new File("C:\\Users\\dipro\\eclipse-workspace\\WebdriverTest\\src\\main\\java\\Screenshots/"+
    	  fileName+".jpg"));
    	  }
    	  
    	  catch( IOException e) {
    		  
    		  e.printStackTrace();
    		  
    	  }
     }
	
	

}

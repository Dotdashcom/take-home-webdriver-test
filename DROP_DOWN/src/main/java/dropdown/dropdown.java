package dropdown;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdown {

	static String url = "http://localhost:7080/dropdown";
	static  WebDriver driver;
    @BeforeTest
	public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
    @Test
    public void dropdown(){
    	WebElement dropdown=driver.findElement(By.id("dropdown"));
    	Select select = new Select(dropdown);
    	select.selectByVisibleText("Option 1");
    	
    	String option1 = select.getFirstSelectedOption().getText();
    	String option2 = select.getFirstSelectedOption().getText();
    	
    	System.out.println(option1);
    	Assert.assertEquals("Option 1",option1);
    
    	select.selectByVisibleText("Option 2");
    	Assert.assertEquals("Option 1",option2);
    	
	}
    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}

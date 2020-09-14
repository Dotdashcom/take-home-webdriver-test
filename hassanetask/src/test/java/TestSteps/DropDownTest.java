package TestSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class DropDownTest {
WebDriver driver;
	
	
	
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/dropdown");
        driver.manage().window().maximize();
	}
	@Test
	public void dropdown() {
		WebElement element = driver.findElement(By.id("dropdown"));
		Select select = new Select (element);
		//1 way
		select.selectByIndex(1);
		//2 way
		//select.selectByVisibleText("Option 1");
		//3 way
		//select.selectByValue("1");
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
}
}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {
	@Test	
	public void NewTab() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize(); // to maximize the window
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("http://localhost:7080/windows");
	System.out.println("Current tab:"+driver.getTitle());//will print the current window name 
	
	driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();// i am clicking the "click here option from the page"
	
	driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");// here i am moving to a new tab
	System.out.println("After switching titile is:"+driver.getTitle()); //this won't print any page title, because new tab is blank
	
	driver.get("http://localhost:7080/windows/new");
	System.out.println("Current tab:"+driver.getTitle());//this will print the current tab

	}
}

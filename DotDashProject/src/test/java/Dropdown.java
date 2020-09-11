import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	@Test	
	public void DropDown() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:7080/dropdown");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		//I am using select class to perform drop down
		Select select = new Select (driver.findElement(By.xpath("//select[@id='dropdown']")));
		
		//this will print all the drop-down name that is present
		System.out.println(driver.findElement(By.xpath("//select[@id='dropdown']")).getText());
		
		//this will select "Option 1"from dropdown
		select.selectByVisibleText("Option 1");
		
		
		

	}

}

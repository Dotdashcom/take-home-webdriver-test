package dockers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {
    
	@Test
    public void Dropdown() throws InterruptedException {
		
		String url = "http://localhost:7080/dropdown";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
		Select dropdown = new Select(dropdownElement);
		//select option 1
		dropdown.selectByVisibleText("Option 1");
		Thread.sleep(1500);
		// select option 2
		dropdown.selectByValue("2");
		Thread.sleep(1500);
		//select option 1
		dropdown.selectByIndex(1);
		driver.close();


	}
}

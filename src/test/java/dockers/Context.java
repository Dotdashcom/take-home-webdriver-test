package dockers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Context {
    
	@Test
    public void ContextMenu() {
		
		String url = "http://localhost:7080/context_menu";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		Actions actions = new Actions(driver);
		
		WebElement context = driver.findElement(By.id("hot-spot"));
		actions.contextClick(context).perform();
		// for alert
		driver.switchTo().alert().accept();
		driver.close();

	}

}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	@Test	
	public void MouseHover() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();;
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:7080/hovers");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement source = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@class='example']//div[1]//div[1]//a[1]"));
		
        Actions ac = new Actions(driver);
		
		ac.moveToElement(source).moveToElement(target).click().build().perform();
		//this is perform the mousehover select "view Profile" from mousehover
		
	}

}

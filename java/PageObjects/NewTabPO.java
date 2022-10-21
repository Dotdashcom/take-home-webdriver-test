package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewTabPO {

	WebDriver driver;
	public NewTabPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void NewTab() throws InterruptedException  {
		WebElement ClickHere= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		ClickHere.click();
		
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		
	}
	
	}
	



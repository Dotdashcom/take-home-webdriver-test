package PageObjects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramesPO {

	WebDriver driver;
	public IFramesPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void iFrames() throws InterruptedException {
		
	driver.switchTo().frame("mce_0_ifr");
	WebElement Cleartext= driver.findElement(By.xpath("//body[@id='tinymce']"));
	Cleartext.clear();
	WebElement Text= driver.findElement(By.id("tinymce"));
	Text.sendKeys("Hello Engineers");
	Thread.sleep(1000);
	String TextDisplayed = driver.findElement(By.id("tinymce")).getText();
	assertEquals(TextDisplayed,"Hello Engineers");

	}
	
	}
	



package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertPO {

	WebDriver driver;
	public JavaScriptAlertPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void javaScript() throws InterruptedException  {
		WebElement JsAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		JsAlert.click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		WebElement success=driver.findElement(By.xpath("//p[@id='result']"));
		
		if(success.isDisplayed()) {
			System.out.println("JS Alert test passed");
		}else {
			System.out.println("JS Alert failed");
		}
		
		WebElement JsConfirm= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		JsConfirm.click();
		driver.switchTo().alert();
		alert.accept();
		
		WebElement JsConfirmSuccess=driver.findElement(By.xpath("//p[@id='result']"));
		if(JsConfirmSuccess.isDisplayed()) {
			System.out.println("JS Confirm test passed");
		}else {
			System.out.println("JS Confirm test failed");
		}
		WebElement JsPromt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		JsPromt.click();
		driver.switchTo().alert();
		alert.sendKeys("Billy Kimber");
		alert.accept();
		
		WebElement JsPrompt=driver.findElement(By.xpath("//p[@id='result']"));
		
		if(JsPrompt.isDisplayed()) {
			System.out.println("JS Prompt test passed");
		}else {
			System.out.println("JS Prompt test failed");
		}
		
	}
	
	}
	



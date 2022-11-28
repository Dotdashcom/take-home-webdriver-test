package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptAlert {
	

	WebDriver driver;
	public JavaScriptAlert(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}
	   @FindBy(xpath = "//button[text()='Click for JS Alert']")
	    WebElement JSAlertBtn;

	    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
	    WebElement JSConfirmBtn;

	    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
	    WebElement JSPrompt;


	    public void clickonJSAlert(){

	        JSAlertBtn.click();
	        Alert alert = driver.switchTo().alert();
	        Assert.assertEquals("I am a JS Alert", alert.getText());
	        alert.accept();
	        WebElement result = driver.findElement(By.id("result"));
	        Assert.assertEquals("You successfuly clicked an alert", result.getText());

	    }
	    
	    public void clickJSConfirm(){

	    	JSConfirmBtn.click();
	        Alert alert = driver.switchTo().alert();
	        Assert.assertEquals("I am a JS Confirm", alert.getText());
	        alert.accept();
	        WebElement result = driver.findElement(By.id("result"));
	        Assert.assertEquals("You clicked: Ok", result.getText());

	    }

	    public void clickJSPrompt(){

	        JSPrompt.click();
	        Alert alert = driver.switchTo().alert();
	        Assert.assertEquals("I am a JS prompt", alert.getText());
	        alert.sendKeys("This is my new message");
	        alert.accept();
	        WebElement result = driver.findElement(By.id("result"));
	        Assert.assertEquals("You entered: This is my new message", result.getText());
	    }
}

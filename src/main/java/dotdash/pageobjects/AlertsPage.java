package dotdash.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertsPage {

public WebDriver driver;
	
	

	@FindBy(xpath="//ul/li[1]/button")
	private WebElement alertButton;
	
	@FindBy(xpath="//ul/li[2]/button")
	private WebElement confirmButton;
	
	@FindBy(xpath="//ul/li[3]/button")
	private WebElement promptButton;
	
	
	public AlertsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnAlert()  {
		alertButton.click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert"); 
		driver.switchTo().alert().accept();
	}
	
	public void clickOnConfirmAlert()  {
		confirmButton.click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm"); 
		driver.switchTo().alert().accept();
	}
	
	public void clickOnPromptAlert() throws InterruptedException {
		promptButton.click();
		driver.switchTo().alert().sendKeys("Hi there");
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertTrue((driver.findElements(By.xpath("//p[contains(text(), 'Hi there')]"))).size()>0); 
	}
}

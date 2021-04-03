package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JsAlertsPage extends TestBase{

	public JsAlertsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	private WebElement jsAlert;
	
	@FindBy(xpath = "//button[@onclick='jsConfirm()']")
	private WebElement jsConfirm;

	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	private WebElement jsPrompt;
	
	@FindBy(id = "result")
	private WebElement result;
	
	public void verifyAlerts() throws InterruptedException {
		
		//WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlert.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("I am a JS Alert", alert.getText());
		alert.accept();
		
		//WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		jsConfirm.click();
		alert = driver.switchTo().alert();
		assertEquals("I am a JS Confirm", alert.getText());
		alert.accept();
		
		
		//WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		//WebElement result = driver.findElement(By.id("result"));
		jsPrompt.click();
		alert = driver.switchTo().alert(); //I am a JS prompt
		alert.sendKeys("Testing Prompt Message");
		alert.accept();
		
		assertEquals("You entered: Testing Prompt Message", result.getText());
		
		System.out.println(result.getText()); 
		
	
		Thread.sleep(5000);
	}
}

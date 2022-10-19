package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class JSAlert extends BaseTest {
	
	public JSAlert() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[1]/button")
	private static WebElement Alert;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[2]/button")
	private static WebElement Confirm;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[3]/button")
	private static WebElement Prompt;
	
	@FindBy(xpath="//*[@id=\"result\"]")
	private static WebElement result;
	
	
	public void Alert() {
		action = new Actions(driver);
		action.moveToElement(Alert).click().build().perform();
		driver.switchTo().alert().getText().toString();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a JS Alert");	
	}
	
	public void Confirm() {
		action = new Actions(driver);
		action.moveToElement(Confirm).click().build().perform();
		driver.switchTo().alert().getText().toString();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a JS Confirm");	
	}
	

	public void Prompt() {
		action = new Actions(driver);
		action.moveToElement(Prompt).click().build().perform();
		driver.switchTo().alert().sendKeys("Shivam");
		driver.switchTo().alert().accept();
		Assert.assertEquals(result.getText().toString(), "You entered: Shivam");	
	}
	

}
package pagepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepackage.BaseTest;

public class DynamicLoading extends BaseTest {

	public DynamicLoading() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='start']/button")
	private static WebElement startbutton;
	
	
	@FindBy(id="finish")
	private static WebElement text;
	
	public boolean start() {
		action = new Actions(driver);
		action.moveToElement(startbutton).build().perform();
		if(startbutton.isEnabled())
		startbutton.click();
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));
		driver.findElement(By.id("finish"));
		System.out.println(text.getText().toString());
		Assert.assertEquals(text.getText().toString(), "Hello World!");
		return true;
	}
}
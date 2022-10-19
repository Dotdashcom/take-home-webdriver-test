package pagepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseTest;

public class NewTab extends BaseTest {

	public NewTab() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/windows/new']")
	private static WebElement tab;
	
	public void tab() {
		action=new Actions(driver);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//a[@href='/windows/new']"), "href", "/windows/new"));
		wait.until(ExpectedConditions.elementToBeClickable(tab));
		action.moveToElement(tab).build().perform();
		tab.click();
		
	}
	
}

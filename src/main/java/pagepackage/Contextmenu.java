package pagepackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class Contextmenu extends BaseTest{

	public Contextmenu() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="hot-spot")
	private static WebElement ContextmenuBox;
	
	private static Contextmenu contextmenu;
	
	public Alert ContextmenuBox() {
		action = new Actions(driver);
		action.moveToElement(ContextmenuBox);
		action.contextClick().build().perform();;
		Alert alert = driver.switchTo().alert();
		return alert ;
	}
	
	public void ContextmenuAssertion() {
		contextmenu=new Contextmenu();
		Assert.assertEquals(contextmenu.ContextmenuBox().getText().toString(), "You selected a context menu");
	}
	
	
}
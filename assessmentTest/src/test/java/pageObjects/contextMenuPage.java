package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.baseutils;

public class contextMenuPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public contextMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for the box
	@FindBy (xpath = "//div[@id = 'hot-spot']")
	WebElement fieldBox;
	
	//methods for right click the box
	public void rightClickOnBox() {
		bu.rightClick(driver, fieldBox, "Box");
	}
	
	//handling alert
	public String handlingAlert() throws InterruptedException {
		Thread.sleep(2000);
		String msg = bu.HandlingAlert(driver, fieldBox, "Alert");
		return msg;
	}
}

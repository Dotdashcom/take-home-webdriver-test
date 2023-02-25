package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class WindowsPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public WindowsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//loactors for click here
	@FindBy(linkText = "Click Here")
	WebElement lnkClickHere;
	
	//locator fro text in new tab
	@FindBy (xpath = "//div[@class='example']")
	WebElement txtMsg;
	
	//methods to check new tab
	public String HandlingNewWindow() {
		bu.clickOnElement(lnkClickHere, "Click here link");
		//moving to new tab
		Set<String> ids = driver.getWindowHandles();  //to get window id 
		Iterator<String> itr = ids.iterator();  //use iterator concepts because we have multiple windows
		String firstWindow = itr.next();
		String secondWindow = itr.next();

		driver.switchTo().window(secondWindow);
		String Message = bu.getMessageText(txtMsg, "New Window");
		return Message;
		
	}
	

}

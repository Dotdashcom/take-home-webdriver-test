package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class FloatingMenuPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public FloatingMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for menu
	@FindBy (linkText = "Home")
	WebElement lnkHome;
	
	//methods to check floating menu
	public boolean HandlingFloatingMenu() throws AWTException {
		//to scroll down the page
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		boolean status = lnkHome.isDisplayed();
		if(status == true) {
			System.out.println("Home menu is displayed");
		} else {
			System.out.println("Home menu is not displayed");
		}
		return status;
	}

}

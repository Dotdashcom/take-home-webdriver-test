package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class MouseHoverPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public MouseHoverPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locators for image1
	@FindBy (xpath = "(//img[@alt='User Avatar'])[1]")
	WebElement lnkImage1;
	
	//locators for image2
	@FindBy (xpath = "(//img[@alt='User Avatar'])[2]")
	WebElement lnkImage2;
		
	//locators for image3
	@FindBy (xpath = "(//img[@alt='User Avatar'])[3]")
	WebElement lnkImage3;
	
	//locator for value in image1
	@FindBy (xpath = "(//div[@class='figcaption'])[1]")
	WebElement lnkCaption1;
	
	//locator for value in image2
	@FindBy (xpath = "(//div[@class='figcaption'])[2]")
	WebElement lnkCaption2;
		
	//locator for value in image3
	@FindBy (xpath = "(//div[@class='figcaption'])[3]")
	WebElement lnkCaption3;
		
	//methods to get the value from the images
	public boolean HandlingImage1() {
		bu.moveToElement_click(driver, lnkImage1);
		String caption1  = bu.getMessageText(lnkCaption1, "Image 1 Caption");
		boolean status1 = bu.ElementDisplayed(lnkCaption1, "Image 1 Caption");
		return status1;
	}
	
	public boolean HandlingImage2() {
		bu.moveToElement_click(driver, lnkImage2);
		String caption2  = bu.getMessageText(lnkCaption2, "Image 2 Caption");
		boolean status2 = bu.ElementDisplayed(lnkCaption2, "Image 2 Caption");
		return status2;
	}
	
	public boolean HandlingImage3() {
		bu.moveToElement_click(driver, lnkImage3);
		String caption3  = bu.getMessageText(lnkCaption3, "Image 3 Caption");
		boolean status3 = bu.ElementDisplayed(lnkCaption3, "Image 3 Caption");
		return status3;
	}

}

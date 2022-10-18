package webtests.Pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_013_MouseHover_POM extends WT_BaseClass {

	
     //Locators
	@FindBy (xpath= "//div[@class='figure'][1]")
	WebElement img1;
	
	@FindBy (xpath = "//h5[contains(text(),'name: user1')]")
	WebElement  User1;
	
	@FindBy(xpath= "//div[@class='figure'][2]")
	WebElement img2;
	
	@FindBy(xpath= "//h5[text()='name: user2']")
	WebElement User2;
	
	@FindBy(xpath= "//div[@class='figure'][3]")
	WebElement img3;
	
	@FindBy(xpath= "//h5[text()='name: user3']")
	WebElement User3;
	
	//Constructor
	public WT_013_MouseHover_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void hoverOnUser1() {
		Actions act = new Actions(driver);
		act.moveToElement(img1).build().perform();
		
	}
	
	public String VerifyhoverOnUser1() {
		return User1.getText();
	}
	
	public void hoverOnUser2() {
		Actions act = new Actions(driver);
		act.moveToElement(img2).build().perform();
		
	}
	
	public String VerifyhoverOnUser2() {
		return User2.getText();
	}
	
	public void hoverOnUser3() {
		Actions act = new Actions(driver);
		act.moveToElement(img3).build().perform();
		
	}
	
	public String VerifyhoverOnUser3() {
		return User3.getText();
	}
	
	
	
	
	
}

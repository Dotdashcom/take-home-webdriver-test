package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage extends BaseClass{
	boolean user1Info;
	boolean user2Info;
	boolean user3Info;
	
	public MouseHoverPage(){
		PageFactory.initElements(driver, this);
	}
	Actions actions = new Actions(driver);
 @FindBy(xpath="//*[@id='content']/div/div[1]/img")
 private WebElement image1;
 @FindBy(xpath="//*[@id='content']/div/div[1]/div/h5")
 private WebElement user1;
 
 @FindBy(xpath="//*[@id='content']/div/div[2]/img")
 private WebElement image2;
 @FindBy(xpath="//*[@id='content']/div/div[2]/div/h5")
 private WebElement user2;
 
 @FindBy(xpath="//*[@id='content']/div/div[3]/img")
 private WebElement image3;
 @FindBy(xpath="//*[@id='content']/div/div[3]/div/h5")
 private WebElement user3;
 
 public boolean image1() {
	 actions.moveToElement(image1).perform();
	 user1Info = user1.isDisplayed();
	 System.out.println("user1 is: "+user1Info);
	 return user1Info;
 }
 
 public boolean image2() {
	 actions.moveToElement(image2).perform();
	 user2Info = user2.isDisplayed();
	 System.out.println("user2 is: "+user2Info);
	 return user2Info;
 }
 public boolean image3() {
	 actions.moveToElement(image3).perform();
	 user3Info = user3.isDisplayed();
	 System.out.println("user3 is: "+user3Info);
	 return user3Info;
 }
 
 
 
 
}

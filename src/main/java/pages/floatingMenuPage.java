package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class floatingMenuPage extends BaseClass{
	boolean menuBefore;
	boolean menuAfter;
	public floatingMenuPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='menu']/ul/li[1]/a")
 private WebElement floatingHome;
 
 public boolean menuBeforeScroll() {
	 System.out.println("in menu before scroll");

	 menuBefore = floatingHome.isDisplayed();
	 System.out.println("menu before is: "+menuBefore);
	 return menuBefore;
 }
 
 public boolean floatingMenuAfterScroll() {
	 System.out.println("in menu after scroll");
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	
	 menuAfter = floatingHome.isEnabled();
	 System.out.println("menu after is: "+menuAfter);
	 return menuAfter;
 }
 
}

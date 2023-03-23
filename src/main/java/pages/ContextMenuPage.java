package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BaseClass {
	public ContextMenuPage(){
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(xpath="//*[@id='hot-spot']")
 private WebElement contextBox;
 
 
 public String rightClickOnContextBox() throws Exception {
	 Thread.sleep(2000);
	 System.out.println("in page class");
	 Actions actions = new Actions(driver);
	 System.out.println("going to actions");
	 actions.contextClick(contextBox).perform();
	 System.out.println("right click done");
	 String alertText =driver.switchTo().alert().getText();
	 System.out.println("Alert text is: "+alertText);
	 driver.switchTo().alert().accept();
	 return alertText;
 }
 
}

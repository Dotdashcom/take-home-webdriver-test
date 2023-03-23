package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends BaseClass {
	public IFramePage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='mce_0_ifr']")
 private WebElement iFrameText;
 
 @FindBy(xpath="//*[@id='tinymce']/p")
 private WebElement contentText;;


public String typeText(String text) {
	System.out.println("in iframe method");
	driver.switchTo().frame(iFrameText);
	System.out.println("frame swir=tched");
	
	contentText.clear();
	contentText.sendKeys(text);
	System.out.println("The text is: "+text);
	
	String textIs=contentText.getText();
	System.out.println("The textIs is: "+textIs);
	return textIs;
}
}

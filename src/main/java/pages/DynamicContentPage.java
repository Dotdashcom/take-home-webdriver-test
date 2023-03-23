package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends BaseClass {
	public DynamicContentPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='content']/div[3]/div[2]")
	 private WebElement content;
	
	public String textBeforeRefresh() {
		String textBeforeRefresh = content.getText();
		return textBeforeRefresh;
	}
	
public String textAfterRefresh() {
	driver.navigate().refresh();
	String textAfterRefresh = content.getText();
	return textAfterRefresh;
}
 
}

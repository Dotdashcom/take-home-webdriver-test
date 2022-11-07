package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
	@FindBy(xpath="//a[contains(text(),'Click here')]")
	private WebElement searchClickLink;
	
	@FindBy(xpath="//div[@id='flash']")
	private WebElement selectmessage;
	
	public NotificationMessagePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void searchlink() {
		searchClickLink.click();
	}
	
	public String msg() {
		System.out.println(selectmessage.getText());
		return selectmessage.getText();
	}

}

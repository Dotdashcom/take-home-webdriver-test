package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
	@FindBy(xpath="//div[@id='menu']")
	private WebElement searchfloating;
	
	public FloatingMenuPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement floatingmenu() {
		return searchfloating;
	}

}

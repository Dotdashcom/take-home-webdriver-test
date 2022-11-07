package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage {
	@FindBy(xpath="//body[@onload='loadError()']")
	private WebElement searchText;
	
	public JavaScriptErrorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String gettext() {
		return searchText.getText();
	}

}

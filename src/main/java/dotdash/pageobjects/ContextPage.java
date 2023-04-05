package dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage {
	
	public WebDriver driver;
	
	@FindBy(id="hot-spot")
	private WebElement context;
	
	
	public ContextPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getContext() {
		return context;
	}


}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BaseDriver {
	protected WebDriver driver;
	
	public BaseDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

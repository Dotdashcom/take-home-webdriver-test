package com.dotDash.DotDash;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContextPageFactory {

	public ContextPageFactory(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//div[@id='hot-spot']" )
	public static WebElement hotBox;

	
	
	public WebElement hotBox() {
		return hotBox;
	}

}
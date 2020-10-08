package com.dotdash.farhan;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OpenNewTabPage {
	public OpenNewTabPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//div[@class='example']//a" )
	public static WebElement newTabBtn;
	
	@FindBy(xpath="//div[@class='example']//h3")
	public static WebElement newWindow;

	
	
	public WebElement newTabBtn() {
		return newTabBtn;
	}
	
	public WebElement newWindow() {
		return newWindow;
	}
}

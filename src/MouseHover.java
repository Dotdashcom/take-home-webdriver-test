package com.dotDash.DotDash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPageFactory {
	public	MouseHoverPageFactory(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
}
	
	@FindBy(xpath = "//div[@class='example']//div[1]//img[1]" )
	public static WebElement firstPic;
	
	@FindBy(xpath = "//div[@class='row']//div[2]//img[1]" )
	public static WebElement secondPic;
	
	@FindBy(xpath = "//div[3]//img[1]" )
	public static WebElement thirdPic;
	
	@FindBy(xpath="//h4[@class='subheader']")
	public static WebElement invalidInput;
	
	@FindBy(xpath ="//h5[text()='name: user1']")
	public static WebElement  firstPopUp;
	
	@FindBy(xpath ="//h5[text()='name: user2']")
	public static WebElement  secondPopUp;
	
	@FindBy(xpath ="//h5[text()='name: user3']")
	public static WebElement  thirdPopUp;
	
	public WebElement firstPic() {
		return firstPic;
	}
	
	public WebElement secondPic() {
		return secondPic;
	}
	
	public WebElement thirdPic() {
		return thirdPic;
	}
	
	public WebElement firstPopUp() {
		return firstPopUp;
	}
	
	public WebElement secondPopUp() {
		return secondPopUp;
	}
	
	public WebElement thirdPopUp() {
		return thirdPopUp;
	}
	
}
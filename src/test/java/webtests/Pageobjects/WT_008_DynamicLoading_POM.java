package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_008_DynamicLoading_POM extends WT_BaseClass{

	//Locators
	@FindBy(xpath= "//button[contains(text(),'Start')]")
	WebElement Startbtn;
	
	@FindBy(xpath= "//h4[contains(text(),'Hello World!')]")
	WebElement ExpectedElement;
	
	
	//Constructor
	public WT_008_DynamicLoading_POM(){
		PageFactory.initElements(driver,this );	
	}
	
	public void StartButton() {
		Startbtn.click();
	}
	
	public WebElement Text() {
		ExpectedElement.getText();
		return ExpectedElement;
	}
    }

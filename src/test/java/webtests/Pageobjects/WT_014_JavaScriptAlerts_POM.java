package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_014_JavaScriptAlerts_POM extends WT_BaseClass {

	
     //Locators
	@FindBy (xpath= "//button[contains(text(),'Click for JS Alert')]")
	WebElement JSalertbtn;
	
	@FindBy (xpath= "//button[contains(text(),'Click for JS Confirm')]")
	WebElement JSconfirmbtn;
	
	@FindBy (xpath= "//button[contains(text(),'Click for JS Prompt')]")
	WebElement JSpromtbtn;
	
	@FindBy(xpath= "//p[@id='result']")
	WebElement result;
	
	//Constructor
	public WT_014_JavaScriptAlerts_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void JSAlertbutton() {
		JSalertbtn.click();
	}
	
	public void JSConfirmbutton() {
		JSconfirmbtn.click();
	}
	
	public void JSPromptbutton() {
		JSpromtbtn.click();
	}
	
	public  String SuccessfulMessage() {
		String text = result.getText();
		System.out.println(text);
		return text;
	}
	
}


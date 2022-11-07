package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertsPage {
	@FindBy(xpath="//button[contains(text(),'Click for JS Alert')]")
	private WebElement selectClickForJSAlert;
	
	@FindBy(xpath="//button[contains(text(),'Click for JS Confirm')]")
	private WebElement selectClickForJSConfirm;
	
	@FindBy(xpath="//button[contains(text(),'Click for JS Prompt')]")
	private WebElement selectClickForJSPrompt;
	
	@FindBy(xpath="//p[@id='result']")
	private WebElement searchText;
	
	public JavascriptAlertsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void selectclickjsalert() {
		selectClickForJSAlert.click();
	}
	
	public void selectclickjsconfirm() {
		selectClickForJSConfirm.click();
	}
	
	public void selectclickjsprompt() {
		selectClickForJSPrompt.click();
	}
	
	public String selecttext() {
		return searchText.getText();
	}
	

}

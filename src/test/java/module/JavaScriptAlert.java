package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class JavaScriptAlert {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.XPATH, using="//button[.='Click for JS Alert']")
	private WebElement jsAlertButton;
	
	@FindBy(how=How.XPATH, using="//button[.='Click for JS Confirm']")
	private WebElement jsConfirmButton;
	
	@FindBy(how=How.XPATH, using="//button[.='Click for JS Prompt']")
	private WebElement jsPromptButton;
	
	@FindBy(how=How.ID, using="result")
	private WebElement result;
	
	public JavaScriptAlert(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void clickAlertButton() {
		jsAlertButton.click();
	}
	
	public void clickOkOnAlertDialog() {
		driver.switchTo().alert().accept();
	}
	
	public void clickConfirmButton() {
		jsConfirmButton.click();
	}
	
	public void clickOkOnConfirmDialog() {
		driver.switchTo().alert().accept();
	}
	
	public void clickCancelOnConfirmDialog() {
		driver.switchTo().alert().dismiss();
	}
	
	public void clickPromptButton() {
		jsPromptButton.click();
	}
	
	public void clickOkOnPromptDialog(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();		
	}
	
	public void clickCancelOnPromptDialog() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getResultText() {		
		return result.getText();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/javascript_alerts");		
	}
	
}

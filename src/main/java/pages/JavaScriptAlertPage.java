/**
 * 
 */
package pages;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class JavaScriptAlertPage extends BasePage {

	public JavaScriptAlertPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//*[@id=\"content\"]/div/ul/li[1]//button")
	WebElement jsAlert;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[2]/button")
	WebElement jsConfirm;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[3]/button")
	WebElement jsPrompt;
	
	@FindBy(id="result")
	WebElement jsMessage;
	
	
public void clickJSAlert() {
	jsAlert.click();
}

public void clickJsConfirm() {
	jsConfirm.click();
}
public void jsPrompt() {
	jsPrompt.click();
}

public boolean verifyAlertMsg(String msg) {
	// TODO Auto-generated method stub
	return driver.switchTo().alert().getText().equalsIgnoreCase(msg);
}


public void acceptAlert() {
	driver.switchTo().alert().accept();
	
}

public boolean isResultMatched(String text) {
	return jsMessage.getText().equalsIgnoreCase(text);
}

public void enterAlertText(String msg) {
	// TODO Auto-generated method stub
	driver.switchTo().alert().sendKeys(msg);
	
}
}

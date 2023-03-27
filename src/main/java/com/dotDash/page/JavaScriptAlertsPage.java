package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class JavaScriptAlertsPage extends BasePage {
	private WebDriver driver;

	public JavaScriptAlertsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='JavaScript Alerts']")
	private WebElement jsHeader;
	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	private WebElement jsAlertButton;
	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	private WebElement jsConfirmButton;
	@FindBy(xpath = "//button[text()='Click for JS Prompt']")
	private WebElement jsPromptButton;
	@FindBy(css = "#result")
	private WebElement jsResultLable;
	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToHoverPage() {
		navigateTo(TestProperties.getProperty("JAVASCRIPT_ALERTS_URL"));
		assertEquals("Hover Page Elements Header",checkWebElementExist(jsHeader), true);
	}
	/**
	 * To Validate JS Alerts functionality
	 * @author Seb Geb
	 */
	
	public void validateJSAlertFeature() {
		clickOnElement(jsAlertButton);
		assertEquals("JS Alert Message", driver.switchTo().alert().getText(),"I am a JS Alert");
		driver.switchTo().alert().accept();
		assertEquals("JS Alert Result Label",jsResultLable.getText(),"You successfuly clicked an alert");
	}

	public void validateJSConfirmFeature() {
		clickOnElement(jsConfirmButton);
		assertEquals("JS Confirm Message", driver.switchTo().alert().getText(),"I am a JS Confirm");
		driver.switchTo().alert().accept();
		assertEquals("JS Alert Result Label",jsResultLable.getText(),"You clicked: Ok");

		clickOnElement(jsConfirmButton);
		assertEquals("JS Confirm Message", driver.switchTo().alert().getText(),"I am a JS Confirm");
		driver.switchTo().alert().dismiss();
		assertEquals("JS Alert Result Label",jsResultLable.getText(),"You clicked: Cancel");
	}
	public void validateJSPromptFeature() {
		clickOnElement(jsPromptButton);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String keysToSend = "This IS MEEE!!!";
		alert.sendKeys(keysToSend);
		alert.accept();
		assertEquals("JS Prompt Result Label",jsResultLable.getText(),"You entered: "+keysToSend);

		clickOnElement(jsConfirmButton);
		assertEquals("JS Prompt Message", alert.getText(),"I am a JS Confirm");
		alert.dismiss();
		assertEquals("JS Prompt Result Label",jsResultLable.getText(),"You clicked: Cancel");
	}
}

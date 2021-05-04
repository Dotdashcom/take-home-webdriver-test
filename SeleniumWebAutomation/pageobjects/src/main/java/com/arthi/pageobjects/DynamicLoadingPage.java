package com.arthi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;


/**
 * 
 * @author Arthina Kumar
 *
 */
public class DynamicLoadingPage extends PageBase {


	private static final String Base_Url = "http://localhost:7080/dynamic_loading/2";
	
	@FindBy(xpath="//div[@id='start']//button")
	private WebElement startBtn;
	
	@FindBy(xpath="//div[@class='example']//h3")
	private WebElement pageHeadingLbl;
	
	@FindBy(xpath="//div[@id='finish']//h4")
	private WebElement helloWorldLbl;
	
	@FindBy(id="loading")
	private WebElement loadingDiv;
	
	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}

	public DynamicLoadingPage navigateToDynamicLoadingPage() {
		driver.get(Base_Url);
		return this;
	}
		
	public DynamicLoadingPage verifyPageLoadingEvent() throws InterruptedException {
		assertContains(pageHeadingLbl, "Dynamically Loaded Page Elements");
		click(startBtn, "Start");
		waitForElementVisible(loadingDiv, 1);
		int i=0;
		while(loadingDiv.isDisplayed()) {
			Thread.sleep(500);
		}
		assertEquals(helloWorldLbl, "Hello World!");		
		return this;
	}
	
	
}

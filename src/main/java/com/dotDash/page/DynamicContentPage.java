package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class DynamicContentPage extends BasePage {
	private WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Dynamic Content']")
	private WebElement dropDynamicContent;
	@FindBy(css = "#content > .row")
	private List<WebElement> contentRowList;
	/**
	 * To check DropDown page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToDynamicContentPage() {
		navigateTo(TestProperties.getProperty("DYNAMIC_CONTENT_URL"));
		assertEquals("Dynamic Content Header",checkWebElementExist(dropDynamicContent), true);
	}
	/**
	 * To Validate DYNAMIC CONTENT functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDynamicContentFeature() {
		LinkedList<String> listItem=new LinkedList<>();
		for(WebElement we:contentRowList){
			System.out.println(we.getText());
			listItem.add(we.getText());
		}
		driver.navigate().refresh();
		for(int index=0;index<contentRowList.size();index++){
			assertNotEquals("Dynamic Page Element",listItem.get(index), contentRowList.get(index).getText());
		}
	}
}

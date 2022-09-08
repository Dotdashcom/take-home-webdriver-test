package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DynamicContentPage {
	static WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		DynamicContentPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'click here')]")
	WebElement REFRESH_HYPERLINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class = 'large-10 columns large-centered']/child::div[3]")
	WebElement THIRD_COLUMN_DYNAMIC_ELEMENT;

//	Global String That Will Be Needed In Multiple Methods And Used On One WebElement
	String beforeTheFirstRefreshText;
	String afterTheFirstRefreshText;
	String afterTheSecondRefreshText;
	String afterTheThirdRefreshText;

//	Methods
	public void refreshPageOnce() {
		beforeTheFirstRefreshText = THIRD_COLUMN_DYNAMIC_ELEMENT.getText();
		REFRESH_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void refreshPageTwice() {
		REFRESH_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void refreshPageAThirdTime() {
		REFRESH_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateContentHasChangedAfterFirstRefresh() {
		afterTheFirstRefreshText = THIRD_COLUMN_DYNAMIC_ELEMENT.getText();
		Assert.assertFalse(afterTheFirstRefreshText == beforeTheFirstRefreshText,
				"Content did not change after first refresh!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateContentHasChangedAfterSecondRefresh() {
		afterTheSecondRefreshText = THIRD_COLUMN_DYNAMIC_ELEMENT.getText();
		Assert.assertFalse(afterTheSecondRefreshText == afterTheFirstRefreshText,
				"Content did not change after second refresh!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateContentHasChangedAfterThirdRefresh() {		
		afterTheThirdRefreshText = THIRD_COLUMN_DYNAMIC_ELEMENT.getText();
		Assert.assertFalse(afterTheThirdRefreshText == afterTheSecondRefreshText,
				"Content did not change after third refresh!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

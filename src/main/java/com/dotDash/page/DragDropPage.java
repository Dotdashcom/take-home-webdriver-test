package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.DragAndDropJsHelper;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

/**
 * This Class is have Context Menu related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class DragDropPage extends BasePage {
	private WebDriver driver;

	public DragDropPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Drag and Drop']")
	private WebElement dragDropHeader;
	private String sectionAID="#column-a";
	private String sectionBID="#column-b";
	@FindBy(css = "#column-a")
	private WebElement sectionA;
	@FindBy(css = "#column-b")
	private WebElement sectionB;

	/**
	 * To navigate to Drag Drop page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToDragDropPage() {
		navigateTo(TestProperties.getProperty("DRAGDROP_URL"));
		Assert.assertEquals(checkWebElementExist(dragDropHeader), true);
	}
	/**
	 * To Validate Drag-Drop functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDragDropFeature() throws IOException {
		DragAndDropJsHelper ddh = new DragAndDropJsHelper("drag_and_drop_helper.js");
		ddh.dragDrop(driver, sectionAID, sectionBID);
		Assert.assertEquals("B",sectionA.findElement(By.xpath("./header")).getText());
		Assert.assertEquals("A",sectionB.findElement(By.xpath("./header")).getText());
		ReportUtil.logMessage(LogStatus.PASS,"Drag Drop Validated","Drag Drop validated successfully");
	}
}

package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;

import com.app.util.PageLinks;

public class DynamicContentPage extends BasePage {

	public DynamicContentPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void visitDynamicContentPage() {
		getDriver().get(PageLinks.DYNAMIC_CONTENT_PAGE);
	}
	
	public void verifyDynamicContentAfterRefresh() throws InterruptedException {
		WebDriver driver = getDriver();
		for (int i = 0; i < 3; i++) {
			String pageSource = driver.getPageSource();
			driver.navigate().refresh();
			assertTrue(!pageSource.equals(driver.getPageSource()), "Content was static");
			Thread.sleep(1000);		
		}
		
	}
	
}

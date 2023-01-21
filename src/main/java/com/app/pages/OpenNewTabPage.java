package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.util.PageLinks;


public class OpenNewTabPage extends BasePage {

	public OpenNewTabPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div/a[text()='Click Here']")
	private WebElement clickHereLink;
	
	
	public void visitOpenNewTabPage() {
		getDriver().get(PageLinks.OPEN_NEW_TAB_PAGE);
	}
	
	public void verifyNewTabOpen() {
		WebDriver driver = getDriver();
		clickHereLink.click();
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();
		
		while(iter.hasNext()) {
			String handle = iter.next();
			if (!currentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}
		
		assertEquals("New Window", driver.getTitle());
		WebElement newWindowTxt = driver.findElement(By.tagName("h3"));
		assertEquals("New Window", newWindowTxt.getText().trim());
	}
	
}

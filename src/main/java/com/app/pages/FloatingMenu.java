package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.util.PageLinks;

public class FloatingMenu extends BasePage {

	public FloatingMenu(WebDriver driver) {
		super(driver);
	}
	

	public void visitFloatingMenuPage() {
		getDriver().get(PageLinks.FLOATING_MENU_PAGE);
	}
		
	public void verifyFloatingMenu() {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        List<WebElement> els = driver.findElements(By.xpath("//div[@id='menu']/ul/li/a"));
        String[] expectedMenuOptions = {"Home", "News", "Contact", "About"};
        
        for(int i = 0; i < els.size(); i++) {
        	assertEquals(expectedMenuOptions[i]	, els.get(i).getText().trim());
        }
	}
}

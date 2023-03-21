package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.app.util.PageLinks;

public class MouseHoverPage extends BasePage {

	public MouseHoverPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='figure']")
	private List<WebElement> figures;
	
	
	public void visitMouseHoverPage() {
		getDriver().get(PageLinks.MOUSE_HOVER_PAGE);
	}
	
	public void verifyElementWithHover() throws InterruptedException {
		WebDriver driver = getDriver();
		for(int i = 0; i < figures.size(); i++) {
			Actions actions = new Actions(driver);
			actions.moveToElement(figures.get(i)).build().perform();
			WebElement img = figures.get(i).findElement(By.tagName("img"));
			WebElement name = figures.get(i).findElement(By.xpath("./div/h5"));
			
			assertTrue(img.isDisplayed());
			assertTrue(name.isDisplayed());
			Thread.sleep(1000);
		}
	}
	
}

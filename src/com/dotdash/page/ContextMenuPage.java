package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/context_menu";
	private WebElement hotSpot;

	public ContextMenuPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		hotSpot = driver.findElement(By.id("hot-spot"));
		assertTrue(hotSpot.isDisplayed());
	}
	
	public void openContextMenu() {
		Actions actions = new Actions(driver);
		actions.contextClick(hotSpot).perform();
	}
	
	public void verifyAlertWindow() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		assertEquals("You selected a context menu", alertText);
	}
}

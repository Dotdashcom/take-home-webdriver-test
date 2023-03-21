package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.util.PageLinks;

public class ContextMenu extends BasePage{
	
	public ContextMenu(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(id = "hot-spot")
	private WebElement contextSqr;
	
	
	public void verifyContextMenu() {
		
		
		WebDriver driver = getDriver();
		Actions actions = new Actions(driver);
		actions.contextClick(contextSqr).perform();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		assertEquals("You selected a context menu", text);
		alert.accept();
	}
	
	public void visitContextMenuPage() {
		getDriver().get(PageLinks.CONTEXT_MENU_PAGE);
	}
	
}

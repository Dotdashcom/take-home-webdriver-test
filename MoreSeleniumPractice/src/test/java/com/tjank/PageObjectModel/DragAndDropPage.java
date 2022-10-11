package com.tjank.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DragAndDropPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public DragAndDropPage() {
		this.URL = this.URL.concat("/drag_and_drop");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@id='column-a']")
	public WebElement columnA;
	
	@FindBy(xpath = "//*[@id='column-b']")
	public WebElement columnB;
	
	@FindBy(xpath = "//*[@id='column-a']//descendant::*")
	public WebElement columnAHeader;	
	
	@FindBy(xpath = "//*[@id='column-b']//descendant::*")
	public WebElement columnBHeader;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Drag and Drop']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void dragAndDrop() {
		int xOffset = columnA.getLocation().getX();
        int yOffset = columnB.getLocation().getY();
        actions.dragAndDropBy(columnA, xOffset, yOffset).build().perform();
	}
	
	public void verifyElementSwitch() {
		System.out.println(columnAHeader.getText());
		Assert.assertEquals(columnAHeader.getText(), "B");
	}
}

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropdownPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public DropdownPage() {
		this.URL = this.URL.concat("/dropdown");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@id='dropdown']")
	public WebElement dropdownMenu;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dropdown List']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void selectDropdownOption(String optionText) {
		Select select = new Select(dropdownMenu);
		select.selectByVisibleText(optionText);
		WebElement option = select.getFirstSelectedOption();
		String selectedText = option.getText();
		Assert.assertEquals(selectedText, optionText);
	}
}

package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicContentPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public DynamicContentPage() {
		this.URL = this.URL.concat("/dynamic_content");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@class='large-10 columns']")
	public List<WebElement> textCols;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dynamic Content']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
		waitForPageToLoad();
	}
	
	public ArrayList<String> getTextCols() {
		ArrayList<String> cols = new ArrayList<String>();
		for(WebElement el : textCols) {
			cols.add(el.getText());
		}
		return cols;
	}
	
	public void checkForDuplicateCols(ArrayList<String> list) {
		ArrayList<String> newList = getTextCols();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(newList.get(i));
			System.out.println(list.get(i));
			if(!newList.get(i).equals(list.get(i))) {
				Assert.assertTrue(true);
				return;
			}
		}
		Assert.fail();
	}
}

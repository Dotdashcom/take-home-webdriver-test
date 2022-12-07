package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage extends BasePage {
	
	private String page = "drag_and_drop";

	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");
	
	public DragDropPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	
	public String getColumnAText() {
		return driver.findElement(columnA).getText();
	}
	
	public String getColumnBText() {
		return driver.findElement(columnB).getText();
	}
	
	
	public void dragAToB() {
		Actions act = new Actions(driver);
		WebElement from = driver.findElement(columnA);
		WebElement to = driver.findElement(columnB);
		act.dragAndDrop(from, to).perform();
	}	
	
	public void dragBToA() {
		Actions act = new Actions(driver);
		WebElement from = driver.findElement(columnB);
		WebElement to = driver.findElement(columnA);
		Action dragAndDrop = act.clickAndHold(from).moveToElement(to).release(to).build();
		dragAndDrop.perform();
	}

	public void goToPage() {
		driver.get(getUrl());
	}

	public void openPage(String url) {
		driver.get(url);
	}

}

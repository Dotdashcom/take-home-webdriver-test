package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage{
	
	private String page = "context_menu";
	
	private By hotSpot = By.id("hot-spot");

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public WebElement getHotSpot() {
		return driver.findElement(hotSpot);
	}
	
	public void rightClickAtHotSpot() {
		Actions action = new Actions(driver);

		action.contextClick(getHotSpot()).perform();		
	}
	

	public void goToPage() {
		driver.get(getUrl());
	}

	public void openPage(String url) {
		driver.get(url);
	}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FloatingMenuPage extends BasePage{
	
	private String page = "floating_menu";

	private By homeMenu = By.cssSelector("#menu > ul > li:nth-child(1) > a");
	private By newsMenu = By.cssSelector("#menu > ul > li:nth-child(2) > a");
	private By contactMenu = By.cssSelector("#menu > ul > li:nth-child(3) > a");
	private By aboutMenu = By.cssSelector("#menu > ul > li:nth-child(4) > a");

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}

	public void clickHomeMenu() {
		driver.findElement(homeMenu).click();
	}
	
	public void clickNewsMenu() {
		driver.findElement(newsMenu).click();
	}
	
	public void clickContactMenu() {
		driver.findElement(contactMenu).click();
	}
	
	public void clickAboutMenu() {
		driver.findElement(aboutMenu).click();
	}
}

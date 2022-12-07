package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {

	private String page = "dynamic_loading/2";
	
	private By startButton = By.cssSelector("#start > button");
	private By loading = By.id("loading");
	private By finish = By.id("finish");
	
	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public void clickStart() {
		driver.findElement(startButton).click();
	}
	
	public By byLoading() {
		return loading;
	}
	
	public String getFinishTxt() {
		return driver.findElement(finish).getText();
	}

}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BaseDriver{
	public FloatingMenuPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(id ="menu")
    public WebElement menuBar;
	
	public void scrollPageByPixel(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = String.format("window.scrollBy(%d,%d)", x, y);
		js.executeScript(script);
	}
	
	public boolean isMenuDisplayed() {
		return menuBar.isDisplayed();
	}
}

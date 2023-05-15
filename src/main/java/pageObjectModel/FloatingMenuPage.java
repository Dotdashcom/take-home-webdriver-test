package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
	private WebDriver driver;

	public FloatingMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	private WebElement floatElem;
	
	
	public boolean elemDisplayed() {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, document.body.scrollHeight)", " ");
	return floatElem.isDisplayed();
	}
}

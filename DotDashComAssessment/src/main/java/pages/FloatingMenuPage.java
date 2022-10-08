package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class FloatingMenuPage extends PageObjectBase{

	public FloatingMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public FloatingMenuPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public FloatingMenuPage scrollToBottomOfPage() {

		JavascriptExecutor scroll = (JavascriptExecutor) getDriver();
		scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/floating_menu";
	}

}

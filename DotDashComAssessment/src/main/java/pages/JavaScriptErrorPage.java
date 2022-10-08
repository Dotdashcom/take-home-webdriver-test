package pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class JavaScriptErrorPage extends PageObjectBase {

	public JavaScriptErrorPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public JavaScriptErrorPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/javascript_error";
	}

}

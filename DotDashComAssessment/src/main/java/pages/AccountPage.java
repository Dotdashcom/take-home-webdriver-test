package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class AccountPage extends PageObjectBase {

	public AccountPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}


	public String successfulLoginMessage() {

		WebElement message = this.getDriver().findElement(By.xpath("//div[@class='flash success']"));
		String successfulLogin = message.getText();

		System.out.println(successfulLogin);

		return successfulLogin;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}

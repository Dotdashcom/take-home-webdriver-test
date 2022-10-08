package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class DynamicLoadingPage extends PageObjectBase{

	public DynamicLoadingPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DynamicLoadingPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public DynamicLoadingPage clickStartButton() {

		WebElement startButton = this.getDriver().findElement(By.xpath("//div[@id='start']/button"));
		startButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

		return this;
	}

	public String retrieveDisplayedMessage() {

		WebElement message = this.getDriver().findElement(By.xpath("//div[@id='finish']/h4"));
		String messageText = message.getText();
		System.out.println(messageText);

		return messageText;
	}

	@Override
	protected String getRelativeUrl() {
		return "/dynamic_loading/2";
	}

}

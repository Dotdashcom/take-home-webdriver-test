package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class NewTabPage extends PageObjectBase{

	public NewTabPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public NewTabPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public NewTabPage clickLink() {

		WebElement link = this.getDriver().findElement(By.xpath("//div[@class='example']/a"));
		link.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));


		return this;
	}

	public String retrieveText() {

		ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(1));

		String text = this.getDriver().findElement(By.xpath("//div[@class='example']//h3")).getText();

		return text;
	}

	@Override
	protected String getRelativeUrl() {
		return "/windows";
	}

}

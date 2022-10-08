package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class IFramePage extends PageObjectBase {

	public IFramePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public IFramePage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public IFramePage accessIFrame(String text) {

		this.getDriver().findElement(By.xpath("//div[@role='alert']/button")).click();
		this.getDriver().switchTo().frame(0);
		WebElement iFrame = getDriver().findElement(By.xpath("//textarea[@data-id='mce_0']"));
		iFrame.click();
		iFrame.clear();
		iFrame.sendKeys(text);

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/iframe";
	}

}

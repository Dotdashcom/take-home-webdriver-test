package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class DynamicControlsPage extends PageObjectBase {

	public DynamicControlsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DynamicControlsPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public DynamicControlsPage clickRemoveButton() {

		WebElement removeButton = this.getDriver().findElement(By.xpath("//form[@id='checkbox-example']//button[@type='button']"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));

		return this;
	}

	public DynamicControlsPage clickAddButton() {

		WebElement addButton = this.getDriver().findElement(By.xpath("//form[@id='checkbox-example']//button[@type='button']"));
		addButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));

		return this;
	}

	public DynamicControlsPage clickEnableButton() {

		WebElement enableButton = this.getDriver().findElement(By.xpath("//form[@id='input-example']//button[@type='button']"));
		enableButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//button[@type='button']")));

		return this;
	}

	public DynamicControlsPage clickDisableButton() {

		WebElement disableButton = this.getDriver().findElement(By.xpath("//form[@id='input-example']//button[@type='button']"));
		disableButton.click();

		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//button[@type='button']")));

		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//button[@type='button']"))));

		return this;
	}



	@Override
	protected String getRelativeUrl() {
		return "/dynamic_controls";
	}

}

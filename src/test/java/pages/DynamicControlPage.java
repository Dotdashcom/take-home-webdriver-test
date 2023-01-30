package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class DynamicControlPage extends BaseTest {

	private By checkbox = By.cssSelector("input[type='checkbox']");
	private By btnRemove = By.xpath("//button[contains(text(),'Remove')]");
	private By btnAdd = By.xpath("//button[contains(text(),'Add')]");
	private By btnEnable = By.xpath("//button[contains(text(),'Enable')]");
	private By btnDisable = By.xpath("//button[contains(text(),'Disable')]");
	private By inputText = By.cssSelector("input[type='text']");

	public void dynamiControlVerificationRemoveAdd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(btnRemove).click();
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(driver.findElement(checkbox))));

		driver.findElement(btnAdd).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
		Assert.assertTrue(driver.findElement(checkbox).isDisplayed());

	}

	public void dynamiControlVerificationEnableDisable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(btnEnable).click();
		Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(inputText, "disabled", "true")));

		driver.findElement(btnDisable).click();
		Assert.assertTrue(wait.until(ExpectedConditions.attributeToBe(inputText, "disabled", "")));

	}

}

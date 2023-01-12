package staffitsolution.qa.wlctointernet.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class DynamicControlsTest extends BaseTest {

	@Test
	public void dynamicControlsTest() throws InterruptedException {

		driver.get(prop.getProperty("dynamicControlsurl"));
		Thread.sleep(2000);
		By remove = By.xpath("//button[@type='button' and text()='Remove']");
		By removeGone = By.xpath("//p[@id='message']");
		By checkBox = By.xpath("//input[@id='checkbox']");
		By add = By.xpath("//button[@type='button' and text()='Add']");
		By addback = By.xpath("//p[@id='message']");

		By enable = By.xpath("//button[@type='button' and text()='Enable']");
		By txtenable = By.xpath("//input[@type='text']");
		By txtDisable = By.xpath("//input[@type='text'][(@disabled)]");
		By checkBox1 = By.xpath("//input[@id='checkbox']");
		By disabled = By.xpath("//button[@type='button' and text()='Disable']");
		// By txtdisable= By.xpath("//p[@id='message']");

		driver.findElement(remove).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String removetext = wait.until(ExpectedConditions.visibilityOfElementLocated(removeGone)).getText();
		System.out.println(removetext);
		Assert.assertEquals(removetext, "It's gone!");

		driver.findElement(add).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		String addtext = wait1.until(ExpectedConditions.visibilityOfElementLocated(addback)).getText();
		System.out.println(addtext);
		Assert.assertEquals(addtext, "It's back!");

		boolean flag = driver.findElement(checkBox).isDisplayed();
		Assert.assertTrue(flag);

		driver.findElement(enable).click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait3.until(ExpectedConditions.elementToBeClickable(txtenable));
		boolean flag1 = driver.findElement(txtenable).isEnabled();
		System.out.println("Enable text flag1: " + flag1);
		Assert.assertTrue(flag1);

		driver.findElement(disabled).click();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(txtDisable));
		boolean flag2 = driver.findElement(txtenable).isEnabled();
		System.out.println("Enable text flag2: " + flag2);
		Assert.assertFalse(flag2);

	}
}

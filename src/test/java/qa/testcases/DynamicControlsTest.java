package qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class DynamicControlsTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void dynamicControlTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_controls");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox']"));

		WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's gone!");

		WebElement addBtn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		addBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(addBtn, "Remove"));
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's back!");

		WebElement textbox = driver.findElement(By.xpath("//form[@id='input-example']/input"));
		
		WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(textbox));
		Assert.assertEquals(textbox.isEnabled(), true);

		WebElement disableBtn = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
		disableBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(disableBtn, "Enable"));
		Assert.assertEquals(textbox.isEnabled(), false);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}

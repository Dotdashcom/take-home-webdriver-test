package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dynamicControls extends base {

	@Test
	public void dynamicControlTest() {
		driver.get(URL + "dynamic_controls ");
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		WebElement Message = driver.findElement(By.xpath("//p[@id='message']"));
		assertTrue(Message.isDisplayed());
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]")));
		WebElement CheckBox = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]"));
		assertTrue(CheckBox.isDisplayed());
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/button[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		WebElement textBox = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/input[1]"));
		assertTrue(textBox.isEnabled());
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/button[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
		String Status = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/button[1]")).getText();
		assertEquals(Status, "Enable");

	}

}

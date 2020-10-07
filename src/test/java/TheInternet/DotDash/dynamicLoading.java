package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dynamicLoading extends base {

	@Test
	public void dynamicLoadingTest() {
		driver.get(URL + "dynamic_loading/2 ");
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		WebElement Text = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
		assertTrue(Text.isDisplayed());
		driver.close();

	}

}

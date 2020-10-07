package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FloatingMenu extends base {
	

	@Test
	public void FloatingMenuTest() throws InterruptedException

	{
		driver.get(URL + "floating_menu ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement HomeButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		assertTrue(HomeButton.isDisplayed());

	}

}

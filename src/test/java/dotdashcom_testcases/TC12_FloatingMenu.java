package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC12_FloatingMenu extends BaseTest {

	// browser for starting browser
	@BeforeMethod
	public void BrowserInvoking() {

		// receiving url to the browser
		driver.get("http://localhost:7080/floating_menu");

	}

	@Test
	public void floating_menu() {
		// scrolling down the web page to 5000 pixels down
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");

		// home menu
		// asserting is home menu displayed after page scroll
		WebElement home_menu_ele = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
		Assert.assertEquals(home_menu_ele.isDisplayed(), true);

		// news menu
		// asserting is news menu displayed after page scroll
		WebElement news_menu_ele = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"));
		Assert.assertEquals(news_menu_ele.isDisplayed(), true);

		// contact menu
		// asserting is contact menu displayed after page scroll
		WebElement contact_menu_ele = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a"));
		Assert.assertEquals(contact_menu_ele.isDisplayed(), true);

		// about menu
		// asserting is about menu displayed after page scroll
		WebElement about_menu_ele = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[4]/a"));
		Assert.assertEquals(about_menu_ele.isDisplayed(), true);
	}


}

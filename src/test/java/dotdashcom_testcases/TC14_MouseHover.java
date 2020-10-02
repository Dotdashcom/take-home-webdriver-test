package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC14_MouseHover {

	public static WebDriver driver;

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to the browser
		driver.get("http://localhost:7080/hovers");

		// maximizing window
		driver.manage().window().maximize();
	}

	@Test
	public void mouse_hover() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// elements of 3 iamges
		// Image elements
		WebElement img1_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		WebElement img2_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
		WebElement img3_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

		// elements of 3 text that available respective to each image when hover the
		// image elements
		// Image hover text elements
		WebElement img1_text_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
		WebElement img2_text_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
		WebElement img3_text_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));

		// elements of 3 text profile that available respective to each image when hover
		// the image elements
		// Image hover text profiles elements
		WebElement img1_profile_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
		WebElement img2_profile_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
		WebElement img3_profile_ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));

		// object is created for Actions
		Actions move_to_ele = new Actions(driver);

		// hover image 1 and asserting for text present after hover of image 1
		// Image 1
		move_to_ele.moveToElement(img1_ele).build().perform();
		Assert.assertEquals(true, img1_text_ele.isDisplayed());
		Assert.assertEquals(true, img1_profile_ele.isDisplayed());

		// hover image 2 and asserting for text present after hover of image 2
		// Image 2
		move_to_ele.moveToElement(img2_ele).build().perform();
		Assert.assertEquals(true, img2_text_ele.isDisplayed());
		Assert.assertEquals(true, img2_profile_ele.isDisplayed());

		// hover image 3 and asserting for text present after hover of image 3
		// Image 3
		move_to_ele.moveToElement(img3_ele).build().perform();
		Assert.assertEquals(true, img3_text_ele.isDisplayed());
		Assert.assertEquals(true, img3_profile_ele.isDisplayed());

	}

	@AfterMethod
	public void teardown() {
		// browser closed
		driver.close();
	}

}

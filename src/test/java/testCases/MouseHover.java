package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class MouseHover extends BaseClass {

	public static WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateMouseHover() throws InterruptedException {
		// locate and click on Hovers link
		WebElement hovers_link = driver.findElement(By.xpath("//a[contains(text(),'Hovers')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hovers_link));
		hovers_link.click();
		Thread.sleep(2000);

		// verify if hovers page is open
		String act_url_hovers = driver.getCurrentUrl();
		String exp_url_hovers = "http://localhost:7080/hovers";
		System.out.println(act_url_hovers);
		if (act_url_hovers.equals(exp_url_hovers)) {
			softassert.assertTrue(true);
		}

		// locating and performing mouse hover on img1
		WebElement img1 = driver.findElement(By.xpath("//div[@id='content']/div/div[1]/img"));
		WebElement img1Info = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(img1).build().perform();
		Thread.sleep(1000);
		// asserting img1 info
		if (img1Info.isDisplayed() == true) {
			softassert.assertTrue(true);
		}
		System.out.println(img1Info.getText());

		// locating and performing mouse hover on img2
		WebElement img2 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/img"));
		WebElement img2Info = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(img2).build().perform();
		Thread.sleep(1000);
		// asserting img2 info
		if (img1Info.isDisplayed() == true) {
			softassert.assertTrue(true);
		}
		System.out.println(img2Info.getText());

		// locating and performing mouse hover on img3
		WebElement img3 = driver.findElement(By.xpath("//div[@id='content']/div/div[3]/img"));
		WebElement img3Info = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(img3).build().perform();
		Thread.sleep(1000);
		// asserting img3 info
		if (img3Info.isDisplayed() == true) {
			softassert.assertTrue(true);
		}
		System.out.println(img3Info.getText());

		softassert.assertAll();

	}

}

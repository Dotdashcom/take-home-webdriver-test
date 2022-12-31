package com.webdriver.assignment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.webdriver.assignment.util.Constants;

public class Assignment {

	private WebDriver driver;

	@BeforeTest
	private void setUp() {
		System.setProperty("WebDriver.chrome.driver", "/Users/joyal/Downloads/chromedriver_win32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/login");
	}

	@AfterTest
	private void afterExcution() {
		driver.quit();
	}

	@Test(priority = 2)
	private void loginSuceess() {
		setUsernameAndPassword(Constants.VALID_USER_NAME, Constants.VALID_PASSWORD);
		driver.findElement(By.cssSelector(".radius")).click();
		System.out.println(driver.findElement(By.cssSelector("div.flash")).getText());
		String successMessage = removeChar(driver.findElement(By.cssSelector("div.flash")).getText());
		assertEquals(successMessage, "You logged into a secure area!");
	}

	@Test(priority = 0)
	private void loginFailureWithInvalidUserName() {
		setUsernameAndPassword(Constants.INVALID_USER_NAME, Constants.VALID_PASSWORD);
		driver.findElement(By.cssSelector(".radius")).click();
		String invalidMessage = removeChar(driver.findElement(By.cssSelector("#flash")).getText());
		System.out.println(invalidMessage);
		Assert.assertEquals(invalidMessage, "Your username is invalid!");
	}

	@Test(priority = 1)
	private void loginFailureWithInvalidPassword() {
		setUsernameAndPassword(Constants.VALID_USER_NAME, Constants.INVALID_PASSWORD);
		driver.findElement(By.cssSelector(".radius")).click();
		String ErrorMessage = removeChar(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		System.out.println(ErrorMessage);
		Assert.assertEquals(ErrorMessage, "Your password is invalid!");
	}

	@Test(priority = 4)
	private void checkCheckBoxes() {
		driver.get("http://localhost:7080/checkboxes");
		driver.findElement(By.xpath(Constants.FIRST_CHECK_BOX)).click();
		Assert.assertTrue(driver.findElement(By.xpath(Constants.FIRST_CHECK_BOX)).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath(Constants.SECOND_CHECK_BOX)).isSelected());
	}

	@Test(priority = 5)
	private void unCheckCheckBoxes() {
		driver.findElement(By.xpath(Constants.FIRST_CHECK_BOX)).click();
		driver.findElement(By.xpath(Constants.SECOND_CHECK_BOX)).click();
		Assert.assertFalse(driver.findElement(By.xpath(Constants.FIRST_CHECK_BOX)).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath(Constants.SECOND_CHECK_BOX)).isSelected());
	}

	@Test(priority = 6)
	private void contextMenuClick() {
		driver.get("http://localhost:7080/context_menu");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("hot-spot"));
		a.moveToElement(move).contextClick().build().perform();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 7)
	private void contextMenuValidation() {
		driver.get("http://localhost:7080/context_menu");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("hot-spot"));
		a.moveToElement(move).contextClick().build().perform();
		String result = driver.switchTo().alert().getText();
		Assert.assertEquals(result, "You selected a context menu");
		driver.switchTo().alert().accept();

	}

	@Test(priority = 8)
	private void dragDrop() {
		driver.get("http://localhost:7080/drag_and_drop");
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		WebElement target = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]"));
		act.dragAndDrop(source, target).build().perform();
		// int x = target.getLocation().x;
		// int y = target.getLocation().y;

		// act.dragAndDropBy(source, x, y).build().perform();

		// act.clickAndHold(source).moveToElement(target, x,
		// y).release(source).build().perform();

	}

	@Test(priority = 9)
	private void selectFirstOptionFromDropdown() {
		driver.get("http://localhost:7080/dropdown");
		WebElement staticDropdown = driver.findElement(By.id("dropdown"));
		Select drop = new Select(staticDropdown);
		drop.selectByVisibleText("Option 1");
		Assert.assertEquals(drop.getFirstSelectedOption().getText(), "Option 1");
	}

	@Test(priority = 10)
	private void selectSecondOptionFromDropdown() {
		driver.get("http://localhost:7080/dropdown");
		WebElement staticDropdown = driver.findElement(By.id("dropdown"));
		Select drop = new Select(staticDropdown);
		drop.selectByVisibleText("Option 2");
		Assert.assertEquals(drop.getFirstSelectedOption().getText(), "Option 2");
	}

	@Test(priority = 11)
	private void refreshPage() {
		try {
			driver.get("http://localhost:7080/dynamic_content?with_content=static");
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test(priority = 12)
	private void contentChangesOnPagerefresh() {
		try {
			driver.get("http://localhost:7080/dynamic_content?with_content=static");
			Thread.sleep(10000);
			List<WebElement> initialItemList = driver
					.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));

			driver.navigate().refresh();
			Thread.sleep(10000);

			List<WebElement> refreshedItemList = driver
					.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));

			for (WebElement webElement : refreshedItemList) {
				System.out.println(webElement.getText());
			}
			Assert.assertNotEquals(initialItemList.get(2), refreshedItemList.get(2));

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test(priority = 13)
	private void wordDisplayed() {
		driver.get("http://localhost:7080/iframe%20Test%20iframe");
		String info = driver.findElement(By.xpath("//pre[contains(text(),\"get '/iframe%20Test%\")]")).getText();
		Assert.assertEquals(true, info.contains("\"Hello World\""));
	}

	@Test(priority = 14)
	private void floatingMenuPageScroll() {
		driver.get("http://localhost:7080/floating_menu");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
	}

	@Test(priority = 15)
	private void floatingMenuVisibility() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Assert.assertTrue(driver.findElement(By.id("menu")).isDisplayed());
	}

	@Test(priority = 16)
	private void mouseHoverOnEachImage() {
		try {
			driver.get("http://localhost:7080/hovers");
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
			action.moveToElement(we).build().perform();
			Thread.sleep(1000);

			action.moveToElement(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"))).build()
					.perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"))).build()
					.perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 17)
	private void validateMouseHoverOnEachImageWithAdditionalInfo() {
		try {
			driver.get("http://localhost:7080/hovers");
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
			action.moveToElement(we).build().perform();
			WebElement user1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
			Assert.assertTrue(user1.isDisplayed());
			Thread.sleep(1000);

			action.moveToElement(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"))).build()
					.perform();
			WebElement user2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
			Assert.assertTrue(user2.isDisplayed());
			Thread.sleep(1000);

			action.moveToElement(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"))).build()
					.perform();
			WebElement user3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
			Assert.assertTrue(user3.isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 18)
	private void validateJsAlertButtonClick() {
		driver.get("http://localhost:7080/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You successfuly clicked an alert");
	}

	@Test(priority = 19)
	private void validateJsConfirmButtonClick() {
		driver.get("http://localhost:7080/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		driver.switchTo().alert().dismiss();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You clicked: Cancel");
	}

	@Test(priority = 20)
	private void validateJsPromptButtonClick() {
		driver.get("http://localhost:7080/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		driver.switchTo().alert().sendKeys("TestPassed");
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You entered: TestPassed");
	}

	@Test(priority = 21)
	private void findJavaScriptError() {
		driver.get("http://localhost:7080/javascript_error");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry + "Jo");
		}
	}

	@Test(priority = 22)
	private void validatePageContainsError() {
		driver.get("http://localhost:7080/javascript_error");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		Boolean hasUndefinedError = false;
		for (LogEntry logEntry : logEntries) {
			if (logEntry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
				hasUndefinedError = true;
				break;
			}
		}
		assertTrue(hasUndefinedError);
	}

	private String removeChar(String value) {
		return value.replace("×", "").trim();
	}

	private void setUsernameAndPassword(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

}

package Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static ChromeDriver driver = null;

	@BeforeClass
	public static void begin() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gujar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

	@Before
	public void setUp() {
		driver.get("http://localhost:7080/login");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
	}

	@Test
	public void login() {
		String actualUrl = "http://localhost:7080/secure";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Test
	public void testLoginFailure() {
		driver.get("http://localhost:7080/login");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUsername("wrongUsername");
		loginPage.setPassword("wrongPassword");

		// Click the login button
		loginPage.clickLoginButton();

		// Assert that the login failed with an error message
		String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage = loginPage.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Login failed for incorrect user and password.");
	}

	@Test
	public void checkbox() {
		driver.get("http://localhost:7080/checkboxes");

		WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();

		Assert.assertTrue(checkbox.isSelected());
		checkbox.click();

		Assert.assertFalse(checkbox.isSelected());

	}

	@Test
	public void contextMenu() {

		driver.get("http://localhost:7080/context_menu");

		WebElement box = driver.findElement(By.xpath("//*[@id='hot-spot']"));

		Actions actions = new Actions(driver);
		actions.contextClick(box).perform();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		assertEquals("You selected a context menu", alertText);

		alert.accept();
	}

	@Test
	public void dropdown() {
		driver.get("http://localhost:7080/dropdown");

		WebElement dropdown = driver.findElement(By.id("dropdown"));

		Select select = new Select(dropdown);

		select.selectByValue("1");

		select.selectByVisibleText("Option 2");

		select.selectByIndex(2);
	}

	@Test
	public void dynamic_content() {
		driver.get("http://localhost:7080/dynamic_content");
		WebElement element = driver.findElement(By.cssSelector(".large-10.columns.large-centered"));

		String initialText = element.getText();

		driver.navigate().refresh();

		WebElement element1 = driver.findElement(By.cssSelector(".large-10.columns.large-centered"));
		String newText = element1.getText();

		assertNotEquals(initialText, newText);
	}

	@Test
	public void download() throws Exception {
		driver.get("http://localhost:7080/download");

		WebElement fileLinkElement = driver.findElement(By.linkText("some-file.txt"));
		fileLinkElement.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String homeDir = System.getProperty("user.home");
		String downloadDir = homeDir + "/Downloads";
		File downloadedFile = new File(downloadDir + "/some-file.txt");
		Assert.assertTrue(downloadedFile.exists());
	}

	@Test
	public void floatingmenu() {
		driver.get("http://localhost:7080/floating_menu");

		WebElement floatingMenu = driver.findElement(By.id("menu"));

		Point initialLocation = floatingMenu.getLocation();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Point updatedLocation = floatingMenu.getLocation();

		assertNotEquals(initialLocation, updatedLocation);
	}

	@Test
	public void iframe() {
		driver.get("http://localhost:7080/iframe");

		driver.switchTo().frame("mce_0_ifr");

		WebElement textAreaElement = driver.findElement(By.id("tinymce"));
		textAreaElement.sendKeys("Hello, World!");

		driver.switchTo().defaultContent();

		WebElement headingElement = driver.findElement(By.tagName("h3"));
		String expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";
		Assert.assertEquals(headingElement.getText(), expectedText);

	}

	@Test
	public void hover() {

		driver.get("http://localhost:7080/hovers");

		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));

		Actions actions = new Actions(driver);

		for (WebElement image : images) {
			actions.moveToElement(image).perform();

			WebElement info = image.findElement(By.cssSelector(".figcaption"));

			assertTrue(info.isDisplayed());
		}
	}

	@Test
	public void jsAlert() throws Exception {
		driver.get("http://localhost:7080/javascript_alerts");

		WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jsAlertButton.click();

		Alert jsAlert = driver.switchTo().alert();
		String alertText = jsAlert.getText();

		assertEquals("I am a JS Alert", alertText);

		jsAlert.accept();

		WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jsConfirmButton.click();

		Alert jsConfirm = driver.switchTo().alert();
		alertText = jsConfirm.getText();

		assertEquals("I am a JS Confirm", alertText);

		jsConfirm.accept();

		WebElement jsPromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		jsPromptButton.click();

		Alert jsPrompt = driver.switchTo().alert();
		String promptMessage = "Hello, world!";
		jsPrompt.sendKeys(promptMessage);
		jsPrompt.accept();

		WebElement result = driver.findElement(By.id("result"));
		String resultText = result.getText();

		assertTrue(resultText.contains(promptMessage));
	}

	@Test
	public void windows() {
		driver.get("http://localhost:7080/windows");

		String mainTab = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
		Set<String> tabs = driver.getWindowHandles();
		tabs.remove(mainTab);
		Assert.assertEquals(tabs.size(), 1);
		driver.switchTo().window((String) tabs.toArray()[0]);
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("New Window"));
		driver.close();
		driver.switchTo().window(mainTab);
	}

	@Test
	public void drag_and_drop() {
		driver.get("http://localhost:7080/drag_and_drop");
		WebElement sourceElement = driver.findElement(By.id("column-a"));
		WebElement targetElement = driver.findElement(By.id("column-b"));

		Actions actions = new Actions(driver);

		actions.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	@Test
	public void dynamic_controls() {
		driver.get("http://localhost:7080/dynamic_controls");
		WebElement checkboxElement = driver.findElement(By.id("checkbox"));
		WebElement removeButtonElement = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));

		// Click the remove button
		removeButtonElement.click();

		// Wait for the checkbox to be removed using explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(checkboxElement));

		// Find the add button element
		WebElement addButtonElement = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));

		// Click the add button
		addButtonElement.click();

		// Wait for the checkbox to be added using explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

		// Find the checkbox element again
		checkboxElement = driver.findElement(By.id("checkbox"));

		// Verify that the checkbox is present and not selected
		if (checkboxElement.isDisplayed() && !checkboxElement.isSelected()) {
			System.out.println("Dynamic Controls Test Passed!");
		} else {
			System.out.println("Dynamic Controls Test Failed!");
		}
	}

	@Test
	public void dynamic_loading() {
		driver.get("http://localhost:7080/dynamic_loading/2");

		WebElement startButton = driver.findElement(By.cssSelector("#start button"));
		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement helloWorldText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

		// Assert that the "Hello World!" text is displayed
		String expectedText = "Hello World!";
		String actualText = helloWorldText.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Test passed: " + actualText + " is displayed.");
		} else {
			System.out.println("Test failed: " + actualText + " is displayed instead of " + expectedText + ".");
		}
	}

	@Test
	public void upload() {
		driver.get("http://localhost:7080/upload");
		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		chooseFileButton
				.sendKeys("C:\\Users\\gujar\\OneDrive\\Desktop\\Notepad Program\\Interview Preparation\\citi.txt");

		// Click the "Upload" button to upload the file
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();

		// Wait for the upload success message to appear
		WebElement successMessage = driver.findElement(By.tagName("h3"));

		// Print the upload success message
		System.out.println(successMessage.getText());
	}

	@Test
	public void jsError() {
		driver.get("http://localhost:7080/javascript_error");
		List<Object> errorLogs = (List<Object>) ((JavascriptExecutor) driver)
				.executeScript("return window._phantomLogs || [];");
		if (errorLogs.size() > 0) {
			System.out.println("JavaScript errors found on the page:");
			for (Object errorLog : errorLogs) {
				System.out.println(errorLog.toString());
			}
		} else {
			System.out.println("No JavaScript errors found on the page.");
		}

		// Assert that the page contains a specific error message
		String expectedErrorMessage = "Cannot read property 'xyz' of undefined";
		List<WebElement> errorMessages = driver.findElements(By.tagName("p"));
		boolean foundError = false;
		for (WebElement errorMessage : errorMessages) {
			if (errorMessage.getText().contains(expectedErrorMessage)) {
				foundError = true;
				break;
			}
		}
		if (foundError) {
			System.out.println("Page contains the expected error message: " + expectedErrorMessage);
		} else {
			System.out.println("Page does not contain the expected error message.");
		}
	}

	@Test
	public void notification() {
		driver.get("http://localhost:7080/notification_message_rendered");
		for (int i = 0; i < 5; i++) {
			WebElement clickHereLink = driver.findElement(By.linkText("Click here"));
			clickHereLink.click();

			// Wait for the notification message to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

			// Check if the notification message contains one of the expected messages
			String message = notification.getText();
			if (message.contains("Action Successful") || message.contains("Action unsuccessful, please try again")
					|| message.contains("Action Unsuccessful")) {
				System.out.println("One of the expected messages was displayed: " + message);
			} else {
				System.out.println("Unexpected message was displayed: " + message);
			}

			// Navigate back to the Click Here page
			driver.navigate().back();
		}

	}
}

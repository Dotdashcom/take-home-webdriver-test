package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageObjects;
import utilities.Base;

public class TestCases extends Base {

	/* TO RUN TESTS IN TERMINAL (REQUIRES MAVEN) GO TO PROJECT DIRECTORY AND TYPE 'mvn test'
	 * 
	 * 
	 * In the current implementation quitting browser after each test cases is
	 * performed due to the specification in GitHub description.
	 */

	@Test
	public void loginSuccess() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/login");
		LoginPageObjects lg = new LoginPageObjects(driver);
		lg.userName().sendKeys("tomsmith");
		lg.password().sendKeys("SuperSecretPassword!");
		lg.login().click();
		Assert.assertTrue(lg.flashMessage().getText().contains("You logged into a secure area!"));

		closeBrowser();
	}

	@Test
	public void loginFailure() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/login");
		LoginPageObjects lg = new LoginPageObjects(driver);
		lg.userName().sendKeys("wronguser");
		lg.password().sendKeys("wrongpassword");
		lg.login().click();
		Assert.assertTrue(lg.flashMessage().getText().contains("is invalid!"));

		closeBrowser();
	}

	@Test
	public void CheckBoxes() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/checkboxes");
		WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());

		checkBox2.click();
		Assert.assertFalse(checkBox2.isSelected());

		closeBrowser();
	}

	@Test
	public void contextMenu() throws InterruptedException, AWTException {
		driver = initializeDriver();
		driver.get("http://localhost:7080/context_menu");
		WebElement box = driver.findElement(By.xpath("//div[@class='example']//div[1]"));

		Actions act = new Actions(driver);
		act.moveToElement(box).contextClick().build().perform();

		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().equals("You selected a context menu"));
		alert.accept();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		closeBrowser();
	}

/*
 * The drag and drop functionality is NOT performing as expected based on standard gesture of dragging and dropping partially as the receiver
 * doesn't accept it with that behavior. Should be taken a look by developer in a real life scenario.
 *  */	
	@Test
	public void dragAndDrop() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
		WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header")).getText().contains("B"));

		closeBrowser();
	}


	@Test
	public void dropDown() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/dropdown");
		Select s = new Select(driver.findElement(By.xpath("//select")));
		WebElement option1 = driver.findElement(By.xpath("//select/option[@value='1']"));
		WebElement option2 = driver.findElement(By.xpath("//select/option[@value='2']"));

		s.selectByValue("1");
		Assert.assertTrue(option1.isSelected());

		s.selectByValue("2");
		Assert.assertTrue(option2.isSelected());

		closeBrowser();
	}

	@Test
	public void dynamicContent() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/dynamic_content");
		WebElement firstRow = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]"));
		String firstRowText = firstRow.getText();

		for (int i = 0; i < 5; i++) {
			driver.navigate().refresh();
			firstRow = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]"));
			Assert.assertFalse(firstRow.getText().equals(firstRowText));
			firstRowText = firstRow.getText();

		}
		closeBrowser();
	}

	@Test
	public void dynamicControls() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/dynamic_controls");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// clicks remove
		driver.findElement(By.xpath("//form[@id='checkbox-example']/button")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//input")));
		Assert.assertFalse(driver.findElements(By.xpath("//form[@id='checkbox-example']//input")).size() > 0);

		// clicks add
		driver.findElement(By.xpath("//form[@id='checkbox-example']/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//input")));
		Assert.assertTrue(driver.findElements(By.xpath("//form[@id='checkbox-example']//input")).size() > 0);

		// clicks Enable
		driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")));
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

		// clicks Disable
		driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
		wait.until(ExpectedConditions
				.not(ExpectedConditions.elementToBeClickable((By.xpath("//form[@id='input-example']//input")))));
		Assert.assertFalse(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

		closeBrowser();
	}

	@Test
	public void dynamicLoading() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.xpath("//div[@id='start']//button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4[1]")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText().equals("Hello World!"));

		closeBrowser();
	}

	@Test
	public void fileDownload() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "download");

		options.setExperimentalOption("prefs", prefs);

		driver = initializeDriver(options);
		driver.get("http://localhost:7080/download");

		driver.findElement(By.xpath("//a[@href=\"download/some-file.txt\"]")).click();

		Thread.sleep(2000);

		closeBrowser();
		
		File fileLocation = new File(System.getProperty("user.dir") + File.separator + "download");

		File[] totalFiles = fileLocation.listFiles();

		Boolean b = false;
		for (File file : totalFiles) {
			
			if(file.getName().equals("some-file.txt"))
				b= true;
			
		}
			Assert.assertTrue(b);
			
	}

	@Test
	public void fileUpload() throws InterruptedException {
		driver = initializeDriver();
		driver.get("http://localhost:7080/upload");

		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(
				System.getProperty("user.dir") + File.separator + "upload" + File.separator + "some-file.txt");
		Thread.sleep(5000);
		// clicks upload
		driver.findElement(By.xpath("//input[@class='button']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='example']/h3")).getText().equals("File Uploaded!"));

		closeBrowser();
	}

	@Test
	public void floatingMenu() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/floating_menu");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='menu']")).isDisplayed());

		closeBrowser();
	}

	@Test
	public void iFrame() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/iframe");

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello World!");
		Assert.assertTrue(driver.findElement(By.xpath("//body[@id='tinymce']")).getText().equals("Hello World!"));

		closeBrowser();
	}

	@Test
	public void mouseHover() {

		driver = initializeDriver();
		driver.get("http://localhost:7080/hovers");
		Actions act = new Actions(driver);

		WebElement user1 = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));
		WebElement user2 = driver.findElement(By.xpath("(//div[@class='figure']/img)[2]"));
		WebElement user3 = driver.findElement(By.xpath("(//div[@class='figure']/img)[3]"));

		act.moveToElement(user1).build().perform();
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figure']/div/h5)[1]")).isDisplayed());

		act.moveToElement(user2).build().perform();
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figure']/div/h5)[2]")).isDisplayed());

		act.moveToElement(user3).build().perform();
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figure']/div/h5)[3]")).isDisplayed());

		closeBrowser();

	}

	@Test
	public void jsAlert() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/javascript_alerts");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Alert", alert.getText());
		alert.accept();

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Confirm", alert.getText());
		alert.accept();

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Hello World!");
		alert.accept();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("Hello World!"));

		closeBrowser();

	}

	@Test
	public void jsError() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/javascript_error");

		String logs = driver.manage().logs().get(LogType.BROWSER).getAll().toString();
		Assert.assertTrue(logs.contains("Cannot read properties of undefined (reading 'xyz')"));

		closeBrowser();

	}

	@Test
	public void openNewTab() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/windows");

		String originalPage = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();

		Set<String> pages = driver.getWindowHandles();

		for (String p : pages) {
			if (!originalPage.equals(p)) {
				driver.switchTo().window(p);

			}

		}

		Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("New Window"));

		quitBrowser();
	}

	@Test
	public void notificationMessage() {
		driver = initializeDriver();
		driver.get("http://localhost:7080/notification_message_rendered");

		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//a[@href=\"/notification_message\"]")).click();
			String message = driver.findElement(By.xpath("//div[@id='flash']")).getText();
			Assert.assertTrue(
					message.contains("Action successful") || message.contains("Action unsuccesful, please try again"));

		}

		closeBrowser();
	}

}

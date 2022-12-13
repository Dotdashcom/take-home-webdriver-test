package com.test;

import static org.junit.Assert.*;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.BaseTest;
import com.pages.LoginPage;
import com.pages.SecurePage;

public class UITest extends BaseTest {

	@Before
	public void setUp() {

		driver.get(getBaseURL());

	}

	@After
	public void tearDown() {
		driver.quit();

	}


	@Test
	public void testLoginSuccess() {

		openURL("/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("tomsmith", "SuperSecretPassword!");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/secure", url);
		SecurePage securePage = new SecurePage(driver);
		assertEquals("You logged into a secure area!", securePage.flasMessage.getText());

	}

	@Test
	public void testLoginFailure() {

		openURL("/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("tomsmit", "SuperSecretPassword!");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/login", url);
		assertEquals("Your username is invalid!", loginPage.flasMessage.getText());

	}

	@Test
	public void testCheckboxes() {

		openURL("/checkboxes");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/checkboxes", url);
		assertEquals("Checkboxes", driver.findElement(By.tagName("h3")));

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[type='checkbox']"));

		//Verify checkboxes are unchecked
		for(int i=0;i<checkboxes.size();i++)
			assertFalse(checkboxes.get(0).isSelected());

		//check all checkboxes
		for(int i=0;i<checkboxes.size();i++)
			checkboxes.get(0).click();

		//Verify checkboxes are checked
		for(int i=0;i<checkboxes.size();i++)
			assertTrue(checkboxes.get(0).isSelected());


	}

	@Test
	public void testContextMenu() {

		openURL("/context_menu");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/context_menu", url);
		assertEquals("Context Menu", driver.findElement(By.tagName("h3")));

		new Actions(driver).moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().perform();

		Alert alert = driver.switchTo().alert();
		assertEquals("You selected a context menu", alert.getText());

	}

	@Test
	public void testDragAndDrop() {

		openURL("/drap_and_drop");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/drap_and_drop", url);
		assertEquals("Drag and Drop", driver.findElement(By.tagName("h3")));

		List<WebElement> cols= driver.findElements(By.xpath("//div[@class='columns']/div"));


		new Actions(driver).dragAndDrop(cols.get(0), cols.get(1)).perform();

		List<WebElement> colsAfterDragAndDrop= driver.findElements(By.xpath("//div[@class='columns']/div"));

		assertEquals("B", colsAfterDragAndDrop.get(0).findElement(By.xpath("//header")).getText());
		assertEquals("A", colsAfterDragAndDrop.get(1).findElement(By.xpath("//header")).getText());

	}

	@Test
	public void testDynamicContent() {

		openURL("/dynamic_content");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/dynamic_content", url);
		assertEquals("Dynamic Content", driver.findElement(By.tagName("h3")));

		String rowOneBeforeRefresh=driver.findElements(By.xpath("//div[@id='content']//div[@class='row']")).get(0).getText();

		driver.navigate().refresh();

		String rowOneAfterRefresh=driver.findElements(By.xpath("//div[@id='content']//div[@class='row']")).get(0).getText();

		assertNotEquals(rowOneBeforeRefresh, rowOneAfterRefresh);

	}


	@Test
	public void testDynamicLoading() {

		openURL("/dynamic_loading");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/dynamic_loading", url);
		assertEquals("Dynamically Loaded Page Elements", driver.findElement(By.tagName("h3")));

		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();

		By HELLO_WORLD=By.tagName("h4");

		WebDriverWait wait=new WebDriverWait(driver,null);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HELLO_WORLD));

		String actualHelloWorlText=driver.findElement(HELLO_WORLD).getText();
		assertEquals("HEllo World", actualHelloWorlText);

	}

	public void testDownLoadFile() throws InterruptedException {

		openURL("/download");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/download", url);
		assertEquals("File Downloader", driver.findElement(By.tagName("h3")));
		driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
		Thread.sleep(5000);

		File folder = new File(System.getProperty("user.dir"));
		//List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		//Look for the file in the files
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fileName.matches("some-file.txt")) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		assertTrue(found);
		f.deleteOnExit();
	}


	public void testUploadFile() throws InterruptedException {

		openURL("/upload");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/upload", url);
		assertEquals("File Uploader", driver.findElement(By.tagName("h3")));
		WebElement fileUpload=driver.findElement(By.id("#file-upload"));
		fileUpload.sendKeys("C:\\Users\\ABC\\some-file.txt");
		Thread.sleep(5000);
		driver.findElement(By.id("#file-submit")).click();
		String uploadedFile=driver.findElement(By.id("#uploaded-files")).getText();
		assertEquals("some-file.txt", uploadedFile);

	}

	public void testFloatingMenu() {

		openURL("/floating_menu");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/floating_menu", url);
		assertEquals("Floating Menu", driver.findElement(By.tagName("h3")));

		WebElement footer=driver.findElement(By.id("page-footer"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer);

		boolean isMenuDisplayed=driver.findElement(By.id("menu")).isDisplayed();

		assertTrue(isMenuDisplayed);

	}

	public void testIFrame() {

		openURL("/iframe");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/iframe", url);
		assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", driver.findElement(By.tagName("h3")));

		driver.switchTo().frame("mce_0_ifr");

		driver.findElement(By.className("mce-content-body")).sendKeys("Some text");
		String value=driver.findElement(By.className("body.mce-content-body>p")).getText();
		assertTrue(value.contains("Some text"));
		driver.switchTo().defaultContent();



	}

	public void testMouseHover() {

		String users[][]= {{"name: user1","View profile"},{"name: user2","View profile"},{"name: user3","View profile"}};

		openURL("/hovers");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/hovers", url);
		assertEquals("Hovers", driver.findElement(By.tagName("h3")));

		List<WebElement> images= driver.findElements(By.cssSelector("div.figure"));

		for(int i=0;i<images.size();i++) {
			new Actions(driver).moveToElement(images.get(i).findElement(By.xpath("//img"))).perform();

			assertEquals(users[i][0],images.get(i).findElement(By.tagName("h5")).getText());
			assertEquals(users[i][1],images.get(i).findElement(By.xpath("//a")).getText());


		}



	}


	public void testJSError() {

		openURL("/javascript_error");

		Logs logs = driver.manage().logs();
		LogEntries logEntries = logs.get(LogType.BROWSER);
		List<LogEntry> errorLogs = logEntries.getAll();


		if (errorLogs.size() != 0) {
			for (LogEntry logEntry: logEntries) {
				System.out.println("Found error in logs: " + logEntry.getMessage() );
			}
		}
		else
			fail("No console errors found");

	}

	public void testNewTab() {

		openURL("/windows");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/windows", url);
		assertEquals("Opening a new window", driver.findElement(By.tagName("h3")));

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Object[] windows= driver.getWindowHandles().toArray();
		String mainWindow=driver.getWindowHandle();

		driver.switchTo().window(windows[0].toString());
		String newTabUrl=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/windows/new	", newTabUrl);
		assertEquals("New Window", driver.findElement(By.tagName("h3")));
		driver.switchTo().window(mainWindow);


	}

	public void testNotificationMSG() {

		HashSet<String> notifMsg= new HashSet<String>();
		notifMsg.add("Action Successful");
		notifMsg.add("Action unsuccessful, please try again");
		notifMsg.add("Action Unsuccessful");

		openURL("/notification_message_rendered");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/notification_message_rendered", url);
		assertEquals("Notification Message", driver.findElement(By.tagName("h3")));

		for(int i=0;i<6;i++) {
			driver.findElement(By.xpath("//a[text()='Click here']")).click();
			boolean flag=notifMsg.contains(driver.findElement(By.xpath("//div[@id='flash']")));
			assertTrue(flag);

		}


	}


	public void testJSAlerts() {

		openURL("/javascript_alerts");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/notification_message_rendered", url);
		assertEquals("JavaScript Alerts", driver.findElement(By.tagName("h3")));

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		Alert alert1=driver.switchTo().alert();
		String alert1Msg=alert1.getText();
		alert1.accept();
		assertEquals("I am a JS Alert", alert1Msg);

		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		assertEquals("You clicked: Ok", driver.findElement(By.xpath("//p[@id='result']")).getText());

		Alert alert3=driver.switchTo().alert();
		alert3.sendKeys("Alert 3");
		assertEquals("You entered: Alert 3", driver.findElement(By.xpath("//p[@id='result']")).getText());



	}

	public void testDynamicControls() {

		openURL("/dynamic_controls");

		String url=driver.getCurrentUrl();
		assertEquals(getBaseURL()+"/dynamic_controls", url);
		assertEquals("Dynamic Controls", driver.findElement(By.tagName("h3")));

		WebElement removeButton= driver.findElement(By.xpath("//button[text()='Remove']"));
		removeButton.click();
		new WebDriverWait(driver, null).until(ExpectedConditions.invisibilityOf(removeButton));
		assertFalse(driver.findElement(By.xpath("//div[contains(.'A checkbox')]/input")).isDisplayed());

		WebElement addButton= driver.findElement(By.xpath("//button[text()='Add']"));
		addButton.click();
		new WebDriverWait(driver, null).until(ExpectedConditions.invisibilityOf(addButton));
		assertTrue(driver.findElement(By.xpath("//div[contains(.'A checkbox')]/input")).isDisplayed());

		WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButton.click();
		new WebDriverWait(driver, null).until(ExpectedConditions.invisibilityOf(enableButton));
		assertTrue(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());

		WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
		disableButton.click();
		new WebDriverWait(driver, null).until(ExpectedConditions.invisibilityOf(disableButton));
		assertFalse(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());

	}

}

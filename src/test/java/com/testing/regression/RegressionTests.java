package com.testing.regression;

import java.awt.AWTException;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import com.testing.core.BaseClass;
import com.testing.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegressionTests extends BaseClass {
	HomePage homepage = null;
	String localPath = null;

	@BeforeMethod
	public void setup() throws AWTException {
		WebDriverManager.chromedriver().setup();
		localPath = System.getProperty("user.dir") + File.separator + "external";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("download.default_directory", localPath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
	}

	@Test
	public void VerifyLoginSuccess() throws InterruptedException {
		driver.get("http://localhost:7080/login");
		homepage.login("tomsmith", "SuperSecretPassword!");
		homepage.verifyLoginSuccess();
	}

	@Test
	public void VerifyLoginFailure() throws InterruptedException {
		driver.get("http://localhost:7080/login");
		homepage.login("tomsmith", "SuperSecretPassword");
		homepage.verifyInvalidLogin();
	}

	@Test
	public void verifyCheckboxes() throws InterruptedException {
		driver.get("http://localhost:7080/checkboxes");
		homepage.verifyCheckbox();
	}

	@Test
	public void verifyContextMenu() throws InterruptedException {
		driver.get("http://localhost:7080/context_menu");
		homepage.verifyContextmenu();
	}

	@Test
	public void verifyDragnDrop() throws InterruptedException {
		driver.get("http://localhost:7080/drag_and_drop");
		homepage.verifyDragDrop();
	}

	@Test
	public void verifyDropDown() throws InterruptedException {
		driver.get("http://localhost:7080/dropdown");
		homepage.verifyDropAndDown();
	}

	@Test
	public void verifyDynamicContent() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_content");
		homepage.verifyDynamicText();
	}

	@Test
	public void verifyDynamicControls() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_controls");
		homepage.verifyDynamicControls();
	}

	@Test
	public void verifyDynamicload() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_loading/2");
		homepage.verifyDynamicLoading();
	}

	@Test
	public void verifyDownload() throws InterruptedException {
		driver.get("http://localhost:7080/download");
		homepage.verifyFileDownload(localPath);
	}

	@Test
	public void verifyUpload() throws InterruptedException {
		driver.get("http://localhost:7080/upload");
		homepage.verifyUpload(localPath + File.separator + "some-file.txt");
	}

	@Test
	public void verifyFloatingMenu() throws InterruptedException {
		driver.get("http://localhost:7080/floating_menu");
		homepage.verifyFloatingMenu();
	}

	@Test
	public void verifyFrames() throws InterruptedException {
		driver.get("http://localhost:7080/iframe");
		homepage.verifyFrames();
	}

	@Test
	public void verifyMouseHover() throws InterruptedException {
		driver.get("http://localhost:7080/hovers");
		homepage.verifyMouseHover();
	}

	@Test
	public void verifyJSAlerts() throws InterruptedException {
		driver.get("http://localhost:7080/javascript_alerts");
		homepage.verifyJSAlerts();
	}

	@Test
	public void verifyJSError() throws InterruptedException {
		driver.get("http://localhost:7080/javascript_error");
		homepage.verifyJSError();
	}

	@Test
	public void verifyNewWindow() throws InterruptedException {
		driver.get("http://localhost:7080/windows");
		homepage.verifyNewWindow();
	}

	@Test
	public void verifyNotifications() throws InterruptedException {
		driver.get("http://localhost:7080/notification_message_rendered");
		homepage.verifyNotifications();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}

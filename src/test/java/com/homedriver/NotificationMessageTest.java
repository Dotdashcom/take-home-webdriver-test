package com.homedriver;

import static org.junit.Assert.fail;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestHelperMethods;

public class NotificationMessageTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;
	private static TestHelperMethods testHelperMethods;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
		testHelperMethods = new TestHelperMethods();
	}

	// Test notification Message.
	@Test
	public void actionSuccessMessage_displayedOnMultipleClicks_check() {
		driver.get(configFileReader.getBaseUrl() + "/notification_message_rendered");
		List<String> messagesPossible = Arrays.asList("Action successful", "Action unsuccesful, please try again",
				"Action Unsuccessful");
		driver.findElement(testHelperMethods.getLocatorByLinkText("Click here")).click();
		String messageOnClick = driver.findElement(By.id("flash-messages")).getText().replace("\n×", "");
		if (!messagesPossible.contains(messageOnClick)) {
			fail("Shown message on click '" + messageOnClick + "' does not match to one of messages possible: "
					+ messagesPossible);
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}

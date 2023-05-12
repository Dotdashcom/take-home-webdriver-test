package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.util.TestUtil;

public class LoginPageTest {

	WebDriver driver;
	TestUtil testUtil = new TestUtil();

	@Before
	public void setUp() {
		// Set the path to the ChromeDriver executable
		try {
			System.setProperty(testUtil.getDriverName(), testUtil.getDriverPath());
			driver = testUtil.getDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// Handle exception if WebDriver setup fails
			System.out.println("Exception occurred while setting up WebDriver: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		try {
			// Close the browser and clean up resources
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			// Handle exception if browser closure fails
			System.out.println("Exception occurred during browser closure: " + e.getMessage());
		}
	}

	@Test
	public void loginSuccessTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/login");

			// Create a plain object model for login credentials
			LoginCredentials credentials = new LoginCredentials("tomsmith", "SuperSecretPassword!");

			// Find the username text box and enter the username
			WebElement usernameTextBox = driver.findElement(By.id("username"));
			usernameTextBox.sendKeys(credentials.getUsername());

			// Find the password text box and enter the password
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.sendKeys(credentials.getPassword());

			// Find the login button and click it
			WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
			loginButton.click();

			// Verify that the user is logged in by checking the page title or other page
			// elements
			String expectedTitle = "You logged into a secure area!";
			WebElement flashElement = driver.findElement(By.id("flash"));

			// Get the text content of the element
			String textContent = flashElement.getText().substring(0, flashElement.getText().indexOf('\n'));

			assertEquals(expectedTitle, textContent);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void loginFailureTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/login");

			// Create a plain object model for login credentials
			LoginCredentials credentials = new LoginCredentials("tomsmith", "invalid password!");

			// Find the username text box and enter the username
			WebElement usernameTextBox = driver.findElement(By.id("username"));
			usernameTextBox.sendKeys(credentials.getUsername());

			// Find the password text box and enter the password
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.sendKeys(credentials.getPassword());

			// Find the login button and click it
			WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
			loginButton.click();

			// Verify that the user is logged in by checking the page title or other page
			// elements
			String expectedTitle = "Your password is invalid!";
			WebElement flashElement = driver.findElement(By.id("flash"));

			// Get the text content of the element
			String textContent = flashElement.getText().substring(0, flashElement.getText().indexOf('\n'));

			assertEquals(expectedTitle, textContent);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	// Plain object model for login credentials
	private static class LoginCredentials {
		private final String username;
		private final String password;

		public LoginCredentials(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}
	}
}

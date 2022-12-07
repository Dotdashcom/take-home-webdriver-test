package testcases;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DynamicControlsPage;

public class DynamicControlsTestCase {
private WebDriver browser;
	
	private DynamicControlsPage contentPage;
	private String messageRemoveFeedback = "It's gone!";
	private String messageAddFeedback = "It's back!";
	private String messageEnableFeedback = "It's enabled!";
	private String messageDisableFeedback = "It's disabled!";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new DynamicControlsPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}
	
	@Test
	public void remove_and_add_checkbox() {
		contentPage.clickAddRemoveButton();
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentPage.getByLoading()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(contentPage.getByLoading()));
		assertEquals(messageRemoveFeedback, contentPage.getMessage());
		assertFalse(contentPage.isCheckboxVisible());
		contentPage.clickAddRemoveButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentPage.getByLoading()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(contentPage.getByLoading()));
		assertEquals(messageAddFeedback, contentPage.getMessage());
		assertTrue(contentPage.isCheckboxVisible());
	}
	
	@Test
	public void enable_and_disable_input() {
		contentPage.clickEnableDisableButton();
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentPage.getByLoading()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(contentPage.getByLoading()));
		assertEquals(messageEnableFeedback, contentPage.getMessage());
		assertTrue(contentPage.isInputEnable());
		contentPage.clickEnableDisableButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentPage.getByLoading()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(contentPage.getByLoading()));
		assertEquals(messageDisableFeedback, contentPage.getMessage());
		assertFalse(contentPage.isInputEnable());
	}
	
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}

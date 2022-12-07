package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DynamicLoadingPage;

public class DynamicLoadingTestCase {
private WebDriver browser;
	
	private DynamicLoadingPage contentPage;
	private String messageFeedback = "Hello World!";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new DynamicLoadingPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}
	
	@Test
	public void loading() {
		contentPage.clickStart();
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentPage.byLoading()));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(contentPage.byLoading()));
		assertEquals(messageFeedback, contentPage.getFinishTxt());
	}
	
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}

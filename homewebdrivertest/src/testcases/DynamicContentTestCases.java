package testcases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DynamicContentPage;

public class DynamicContentTestCases {
	
	private WebDriver browser;
	
	private DynamicContentPage contentPage;
	private ArrayList<String> contentsInTxt = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new DynamicContentPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}
	
	@Test
	public void contents_display_are_being_changed() {
		for (int i = 0; i < 5; i++) {
			contentPage.refreshContents();
			List<WebElement> newContents = contentPage.getAllContent();
			for (WebElement webElement : newContents) {
				String text = contentPage.getImgUrlFromContent(webElement);
				text+= "\n" + contentPage.getTextFromContent(webElement);
				contentsInTxt.add(text);
			}
			browser.navigate().refresh();
		}
		
		String old = contentsInTxt.get(0);
		boolean isHaveBeingChanged = true;
		for (int i = 1; i < contentsInTxt.size(); i++) {
			String cur = contentsInTxt.get(i);
			if(old == cur) {
				isHaveBeingChanged = false;
			}
			old = cur;
		}
		
		assertTrue(isHaveBeingChanged);
	}
	
	@Test
	public void contents_display_are_being_changed_with_static() {
		contentPage.goToPageWithAppend();
		for (int i = 0; i < 5; i++) {
			contentPage.refreshContents();
			List<WebElement> newContents = contentPage.getAllContent();
			for (WebElement webElement : newContents) {
				String text = contentPage.getImgUrlFromContent(webElement);
				text+= "\n" + contentPage.getTextFromContent(webElement);
				contentsInTxt.add(text);
			}
			browser.navigate().refresh();
		}
		
		String old = contentsInTxt.get(0);
		boolean isHaveBeingChanged = true;
		for (int i = 1; i < contentsInTxt.size(); i++) {
			String cur = contentsInTxt.get(i);
			if(old == cur) {
				isHaveBeingChanged = false;
			}
			old = cur;
		}
		
		assertTrue(isHaveBeingChanged);
	}
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}

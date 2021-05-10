package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContentPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/dynamic_content";
	private List<WebElement> photos;
	private List<WebElement> descriptions;

	public DynamicContentPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		photos = driver.findElements(By.cssSelector("div[class='large-2 columns']>img"));
		for (WebElement photo : photos) {
			assertTrue(photo.isDisplayed());
		}
		
		descriptions = driver.findElements(By.cssSelector("div[class='large-10 columns']"));
		for (WebElement description : descriptions) {
			assertTrue(description.isDisplayed());
		} 
	}
	
	public DynamicContentPage reload() {
		driver.navigate().refresh();
		return new DynamicContentPage(driver);
	}
	
	@Override
	public int hashCode() {
		String[] photoUrls = photos.stream().map(we -> we.getAttribute("src")).toArray(String[]::new);
		String[] descriptionStrings = descriptions.stream().map(we -> we.getText()).toArray(String[]::new);
		return Objects.hash(Stream.of(photoUrls, descriptionStrings).flatMap(Stream::of).toArray());
	}
}

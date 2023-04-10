package util;

import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestHelperMethods {

	By contentInPage = By.xpath("//div[@class='large-10 columns']");

	public void checkBoxSelect(Boolean isSelected, WebElement checkBox) {
		if (isSelected && !checkBox.isSelected()) {
			checkBox.click();
		} else if (!isSelected && checkBox.isSelected()) {
			checkBox.click();
		}
	}

	public List<String> getContentsInPage(WebDriver driver) {
		List<WebElement> contents = driver.findElements(contentInPage);
		List<String> contentsInPage = null;
		for (WebElement content : contents) {
			contentsInPage = Collections.singletonList(content.getText());
		}
		return contentsInPage;
	}
	
	public By getLocatorUsingBtnText(String text) {
		return By.xpath(String.format("//button[text()= '%s']", text));
	}
	
	public By getLocatorByLinkText(String text) {
		return By.xpath(String.format("//*[@href][text()= '%s']", text));
	}

}

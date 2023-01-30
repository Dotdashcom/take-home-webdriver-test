package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;

public class DynamicContentPage extends BaseTest {

	private By columns = By.cssSelector(".large-10.columns");

	public List<String> dynamicContAfterReload() {
		driver.navigate().refresh();
		return getContent();

	}

	public List<String> getContent() {
		List<WebElement> columnsEl = driver.findElements(columns);
		List<String> texts = new ArrayList<String>();
		for (WebElement col : columnsEl) {
			texts.add(col.getText());
		}
		return texts;
	}

	public void assertArraysNotEqual() {
		Assert.assertNotEquals(getContent(), dynamicContAfterReload());
	}

}

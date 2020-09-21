package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;

public class DynamicContentTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/dynamic_content");

	}

	// Test refreshes the page a couple of times.

	// Test asserts that the content changes on each refresh.
	@Test

	public void refreshDynamicContent() {

		List<WebElement> imageContents = driver.findElements(By.xpath("//*[contains(@class,'large-2 columns'"));
		List<WebElement> textContents = driver.findElements(By.xpath("//*[contains(@class,large-10 columns"));

		WebElement content = driver.findElement(By.xpath("//*[@id=\"content\"]/div"));

		for (int i = 0; i < textContents.size(); i++) {
			for (int j = i + 1; j < textContents.size(); j++) {

				driver.navigate().refresh();
				if (textContents.get(i).equals(textContents.get(j))) {
					System.out.println("Content is static");
				} else {System.out.println("content is dynamically changing");}
			}
		}

	

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}

}

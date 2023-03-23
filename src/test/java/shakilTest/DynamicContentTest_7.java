/*
package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicContentTest_7 extends TestBase {
	
	@Test
	public void testDynamicContentChangesWithPageReload() {
		// Navigate to the dynamic content page
		driver.get("http://localhost:7080/dynamic_content");
		
		// Get the initial contents of the three sections
		List<WebElement> sections = new ArrayList<WebElement>();
		sections.add(driver.findElement(By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[1]/div[2]")));
		sections.add(driver.findElement(By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[2]/div[2]")));
		sections.add(driver.findElement(By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[3]/div[2]")));
		
		List<String> initialContents = new ArrayList<String>();
		for (WebElement section : sections) {
			initialContents.add(section.getText());
		}
		
		// Refresh the page three times
		for (int i = 0; i < 3; i++) {
			driver.navigate().refresh();
			
			// Get the new contents of the three sections
			List<String> newContents = new ArrayList<String>();
			for (WebElement section : sections) {
				try {
					newContents.add(section.getText());
				} catch (StaleElementReferenceException e) {
					// If the element is stale, get a new reference to it and try again
					section = driver.findElement(By.xpath(section.getXPath()));
					newContents.add(section.getText());
				}
			}
			
			// Verify that the contents of the three sections change on each refresh
			Assert.assertNotEquals(newContents, initialContents);
			
			// Shuffle the order of the sections for the next refresh
			Collections.shuffle(sections);
			initialContents = newContents;
		}
	}
}


*/
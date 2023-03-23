package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest_3 extends TestBase {
	
	@Test
	public void checkboxesTest() {
		driver.get("http://localhost:7080/checkboxes");
		
		// Find the checkboxes using the XPath expressions
		WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
		
		// Verify that checkbox 1 is unchecked by default
		Assert.assertFalse(checkbox1.isSelected());
		
		// Verify that checkbox 2 is checked by default
		Assert.assertTrue(checkbox2.isSelected());
		
		// Click on checkbox 1 to check it
		checkbox1.click();
		
		// Verify that checkbox 1 is checked
		Assert.assertTrue(checkbox1.isSelected());
		
		// Click on checkbox 2 to uncheck it
		checkbox2.click();
		
		// Verify that checkbox 2 is unchecked
		Assert.assertFalse(checkbox2.isSelected());
	}
}

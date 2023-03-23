package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest_6 extends TestBase {
	
	@Test
	public void testSelectDropdownOption() {
		// Navigate to the dropdown page
		driver.get("http://localhost:7080/dropdown");
		
		// Select option 1 from the dropdown
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 1");
		
		// Verify that option 1 is selected
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
		
		// Select option 2 from the dropdown
		select.selectByVisibleText("Option 2");
		
		// Verify that option 2 is selected
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
	}
}

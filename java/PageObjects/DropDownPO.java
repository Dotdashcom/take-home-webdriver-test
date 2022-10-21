package PageObjects;


import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPO {

	WebDriver driver;
		
	public DropDownPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void dropDown()
	{

		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		dropdown.selectByVisibleText("Option 1");
		String Text1 = driver.findElement(By.id("dropdown")).getText();
		assertTrue(Text1.contains("1"));
		dropdown.selectByVisibleText("Option 2");
		String Text2 = driver.findElement(By.id("dropdown")).getText();
		assertTrue(Text2.contains("2"));
		dropdown.selectByVisibleText("Option 2");
		
	}
	
}


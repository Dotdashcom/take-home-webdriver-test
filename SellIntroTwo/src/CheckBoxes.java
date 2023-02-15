import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {

	@Test
	public static void checkBoxTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/checkboxes");
		
	WebElement first= driver.findElement(By.xpath("//form/input[1]"));
	first.click();
	boolean firstCheck=first.isSelected();
	
	WebElement second= driver.findElement(By.xpath("//form/input[2]"));
	 second.click();
	 boolean secondCheck=second.isSelected();
	 
	 Assert.assertTrue(firstCheck);
	 Assert.assertFalse(secondCheck);
	 
	 
	 driver.quit();
	 
	 

	}

}

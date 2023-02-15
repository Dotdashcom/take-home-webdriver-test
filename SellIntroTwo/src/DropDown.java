import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

	@Test
	public static void DropDownTest() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/dropdown");
		
		WebElement dropDownElement=driver.findElement(By.id("dropdown"));
		
		Select dropDown=new Select(dropDownElement);
		
		dropDown.selectByIndex(1);
		
		driver.quit();

	}

}

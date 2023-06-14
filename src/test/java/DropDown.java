import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
		
	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/dropdown");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void dropDown1() {
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 1");
		assert dropdown.getFirstSelectedOption().getAttribute("value").equals("1");
	}

	@Test
	public void dropDown2() {
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 2");
		assert dropdown.getFirstSelectedOption().getAttribute("value").equals("2");
	}

}

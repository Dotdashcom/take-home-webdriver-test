import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkboxes {
		
	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();					
		driver.get("http://localhost:7080/checkboxes");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void checkAllBoxes() {
		WebElement checkbox = driver.findElement(By.id("checkboxes"));
		List<WebElement> boxes = checkbox.findElements(By.xpath("//input[@type='checkbox']"));
		boxes.forEach((box) -> {
			if (box.getAttribute("checked") == null)
				box.click();
		});
		boxes.forEach(a -> {
			assert a.getAttribute("checked") != null;
		});

	}

	// for Sbt
	@Test
	public void uncheckAllBoxes() {
		WebElement checkbox = driver.findElement(By.id("checkboxes"));
		List<WebElement> boxes = checkbox.findElements(By.xpath("//input[@type='checkbox']"));
		boxes.forEach((box) -> {
			if (box.getAttribute("checked") != null)
				box.click();
		});
		boxes.forEach(a -> {
			assert a.getAttribute("checked") == null;
		});

	}
}

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicControls {

	@Test
	public static void DynamicControlsTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/dynamic_controls");
		
		driver.manage().window().maximize();
		
		By removeButton=By.cssSelector("#checkbox-example button");
		By checkBox=By.id("checkbox");
		
		driver.findElement(removeButton).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
		
		
		By input=By.cssSelector("#input-example input");
		By inputButton=By.cssSelector("#input-example button");
		
		System.out.println(driver.findElement(input).isEnabled());
		driver.findElement(inputButton).click();
		wait.until(ExpectedConditions.textToBe(inputButton, "Disable"));
		
		

	}

}

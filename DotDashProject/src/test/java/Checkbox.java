import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {




	@Test	
	public void checkBox() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:7080/checkboxes" );
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		//this will check the checkbox 1
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		//this will verify and return if your checkbox is selected or not
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
		Thread.sleep(2000);

		// this will uncheck the "checkbox 2" which is already checked
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		//this will verify and return if your checkbox is selected or not
		System.out.println(By.xpath("//input[@type='checkbox'][2]"));
	



	}
}


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFailures {

	@Test	
	public void LoginFailures() {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomSmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("khfsgfwakfw");
		
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		
		
		//this will print out the login error message
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
				

		
		

	}

}

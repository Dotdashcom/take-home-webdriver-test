package Testcases;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_JSalert {
	@Test
	public void jsalerttest() {
		
		String URL ="http://localhost:7080/javascript_alerts";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		 alert.click();
		 Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("You successfully clicked an alert");
		 assertTrue(verifyTitle);
		 
		 Alert alert1 = driver.switchTo().alert();
		 alert1.accept();
		 
		 WebElement confirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		 confirm.click();
		 Boolean verifyTitle1 = driver.getTitle().equalsIgnoreCase("You clicked: Ok");
		 assertTrue(verifyTitle1);
		 
		 Alert alert2 = driver.switchTo().alert();
		 alert2.accept();
		 
		 
		 WebElement prompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		 prompt.click();
		
		 Alert alert3 = driver.switchTo().alert();
		String  alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert3.accept();
		 
		 
		 
		 
		 
		 
	}

}

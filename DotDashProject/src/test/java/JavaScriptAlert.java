import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlert {

	@Test	
	public void Alert() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:7080/javascript_alerts");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        // So for JavaScript alert pop up I am using Alert class and using the accept() method
        // to accept the alert pop up
        // this will test "JS Alert"
         driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
         Alert alert1 = driver.switchTo().alert();
         Thread.sleep(2000);
         System.out.println(alert1.getText());
         alert1.accept();//this will accept the alert
        
         
         // this will test "JS Confirm"
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();  
        Thread.sleep(2000);
        Alert alert2 = driver.switchTo().alert(); 
        System.out.println(alert2.getText());
        alert2.dismiss();// this will click cancel on the alert window
        
        //this will check "Js Promt"
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();  
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Hello");
        Thread.sleep(2000);//will wait for 2 seconds before accept 
        alert3.accept();


	}

}

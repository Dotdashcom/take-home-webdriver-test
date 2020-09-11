package com.Test;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dotDashAssignment {

	public WebDriver driver;
	
	@BeforeTest
	@Parameters("setup")
	public void setupDriver(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
        driver.get("http://localhost:7080" );
		
		driver.manage().window().maximize(); // to maximize the window
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		
	}
	
	@Test	
	public void checkBox() {
		 
		  driver.findElement(By.xpath("//a[contains(text(),'Checkboxes')]")).click(); 
		  
		  //this will check the checkbox 1
		  driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		  //this will verify and return if your checkbox is selected or not
		  System.out.println(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
			
		  // this will uncheck the checkbox 1 that checked previusly
		  driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		  //this will verify and return if your checkbox is selected or not
		  System.out.println(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
		  
		  

	}

	@Test
	//(enabled = false)
	public void DragAndDrop() {
		
		        driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
		        
		        //inspecting the element that i want to drag
				WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
				
				//inspecting the element where i want to drop it
				WebElement target = driver.findElement(By.id("column-b"));
				
				Actions ac = new Actions(driver);
				//this will perfrom the drag and drop
				ac.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
				
				

		
		
	}
		
	@Test//(enabled = false)
	public void LoginSuccess() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomSmith");//username
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");//password
		
		driver.findElement(By.xpath("//button[@class='radius']")).click();//login
		
		//this will print out the login error message
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
	
		
	}
	/*
	
	@Test(enabled = true) // if false then this particular test wont run. 
	                      //By default its always false
	public void test1() {
		System.out.println(driver.getTitle());
		/*
		List <WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN);
		
		//if we want to use two keyboard key at the same time, we need to use 
		
		a.sendKeys(Keys.chord(Keys.CONTROL, Keys.ALT));
		
		JavascriptExecutor js = (JavascriptExecutor)driver; //javasriptexecuotr is the interafec 
		
		js.executeScript("window.scrollBy (0,500)");// executeScript is the method
		
		
		
	
	}
	
	@Test (groups = "hello")
public void test2() {
System.out.println(driver.getTitle());

}
	
	
	@AfterTest
	public void quit() {
		driver.quit();
		
	}*/
	
}

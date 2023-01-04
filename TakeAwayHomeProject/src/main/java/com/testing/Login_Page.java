/**
 * 
 */
package com.testing;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;




/**
 * @author priyanka goswami
 * this is login page file.
 *
 */
public class Login_Page {
	
	public static WebDriver driver;
	
	//Login Elements//
	@FindBy(xpath="//input[contains(@id,\"username\")]") public WebElement userName;										
	@FindBy(xpath="//input[contains(@name, \"password\")]") public WebElement password;		
	@FindBy(xpath="//button[@type=\"submit\"]") public WebElement loginButton;		
	@FindBy(xpath="//h4[@class=\"subheader\"]") public WebElement verifiedLoginMessage;	
	@FindBy(xpath="//div[@id=\"flash-messages\"]/div") public WebElement loginErrorMessage;	
	

	//Invoking browser
	public void setup() throws  InterruptedException{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\workspace3\\Final_Project\\Project_Data\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		driver.get("http://localhost:7080/login");
		
	}
	
	//Scenario: Login Success
	public void loginSuccess() {
		userName.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		loginButton.click();
		String actualMessage="Welcome to the Secure Area. When you are done click logout below." ;
		String expectedMessage=verifiedLoginMessage.getText();
	    Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//Scenario: Login failed
	public void loginFailed() {
		userName.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!jhdvsv");
		loginButton.click();
		//String actualMessage="Your password is invalid!" ;
		boolean expectedMessage=loginErrorMessage.getText().contains("Your password is invalid!");
	    Assert.assertTrue(expectedMessage);
	}
	
	//Closing browser
	public void tearDown() {
		driver.quit();
	}

}

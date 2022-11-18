import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class webdriverTest {
	
	@BeforeEach
	   public void setUp() {
		//driver.manage().window().maximize();
	   }

	   @BeforeEach
	   public void tearDown() {
		   //driver.close();
	   }

	   @Test
	   public void LoginSuccess() {
		   System.setProperty("webdriver.chrome.driver", "C:\\D backup\\DockerPrac\\\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   //Navigate to URL
		   String url = "http://localhost:7080/login";
		   driver.get(url);
		   //Enter Username
		   WebElement href = driver.findElement(By.xpath("//input[@id='username']"));		   
		   WebElement username =driver.findElement(By.xpath("//input[@id='username']"));
		   username.sendKeys("tomsmith");
		   //Enter Password
		   WebElement password =driver.findElement(By.xpath("//input[@id='password']"));
		   password.sendKeys("SuperSecretPassword!");
		   //Click on Login button
		   WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		   button.click();
		   //Verify text after Login
		   driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]"));
		   //Close the Website
		   driver.quit();
		   
	    }
	   
	   
	   @Test
	   public void LoginFailure() {
		   WebDriver driver = new ChromeDriver();
		   //Navigate to URL
		   String url = "http://localhost:7080/login";
		   driver.get(url);
		   //Enter Username
		   WebElement href = driver.findElement(By.xpath("//input[@id='username']"));		   
		   WebElement username =driver.findElement(By.xpath("//input[@id='username']"));
		   username.sendKeys("tomsmith");
		   //Enter Password
		   WebElement password =driver.findElement(By.xpath("//input[@id='password']"));
		   password.sendKeys("SecretPassword!");
		   //Click on Login button
		   WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		   button.click();
		   //Verify text for invalid login
		   driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
		   //Quit the browser
		   driver.quit();
		   
	    }
	   
	   @Test
	   public void CheckBoxes() {
		   WebDriver driver = new ChromeDriver();
		   //Navigate to URL
		   String url = "http://localhost:7080/checkboxes";
		   driver.get(url);
		   
		   // for all checked checkboxes
		   driver.findElements(By.cssSelector("input:checked[type='checkboxs']"));
		   // for all notchecked checkboxes
		   driver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));
		   
		   //Quit the browser
		   driver.quit();
		   
	    }
}

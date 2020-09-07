package dockers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWebDriver {
	
	public WebDriver Login(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
	
	public By username = By.id("username");
	public By password = By.id("password");
	public By loginButton = By.xpath("//button[@class='radius']");
	WebDriver driver;
	
	
	
	public void setUsername(String strUserName) {
		driver.findElement(username).sendKeys(strUserName);
	}
	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	public void clickLogin(){
        driver.findElement(loginButton).click();
	}
}
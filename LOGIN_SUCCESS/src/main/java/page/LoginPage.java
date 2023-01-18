package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
	static WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"username\"]")
	WebElement USERNAME_LOCATOR;
	@FindBy(how = How.XPATH,using ="//*[@id=\"password\"]")
	
	WebElement PASSWORD_LOCATOR;
	@FindBy(how = How.XPATH,using ="//*[@id=\"login\"]/button/i")
	WebElement LOGIN_LOCATOR;
	
	
   
	public void insertUserName(String userName) {
		USERNAME_LOCATOR.sendKeys(userName);
	}
	public void insertPassword(String password) {
		PASSWORD_LOCATOR.sendKeys(password);
	}
	public void clickTologin() {
		LOGIN_LOCATOR.click();
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void assertion() {
          String actualTitle=driver.getTitle();
          String expectedTitle="The Internet";
          Assert.assertEquals(actualTitle,expectedTitle);
      
	}
	 
}

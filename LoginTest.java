package testPackages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest{

  WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
   
    driver.get("http://localhost:7080/login");
  }

  @Test
  public void testLoginSuccess() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("tomsmith", "SuperSecretPassword!");
    Assert.assertEquals("Secure Area", driver.getTitle());
  }

  @Test
  public void testLoginFailure() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Wronguser", "WrongPassword");
    WebElement errorMessage = driver.findElement(By.id("flash"));
    String actualErrorMessage = errorMessage.getText();
    String expectedErrorMessage = "Your username is invalid!\n×";
    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
  }

  public class LoginPage {

    private WebDriver driver;

    private WebElement usernameField = driver.findElement(By.id("username"));
    private WebElement passwordField = driver.findElement(By.id("password"));
    private WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

  
    public LoginPage(WebDriver driver) {
      this.driver = driver;
    }

    public void login(String username, String password) {
   
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      loginButton.click();
    }
  }

}

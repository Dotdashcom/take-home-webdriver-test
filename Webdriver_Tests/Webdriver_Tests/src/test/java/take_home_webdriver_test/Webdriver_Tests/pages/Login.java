package take_home_webdriver_test.Webdriver_Tests.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class Login{
  WebDriver driver;
  
  @FindBy(id="username")
  public WebElement username;
  
  @FindBy(id="password")
  public WebElement password;
  
  @FindBy(xpath=".//*[@type='submit']")
  public WebElement loginBtn;
  
  @FindBy(linkText=" Logout")
  public WebElement logoutBtn;
  
  public Login(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
  }
 
}

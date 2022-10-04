import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class LoginTest {

    TestUtils testUtils = new TestUtils();

    WebDriver driver;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(UrlConstants.Login_URL);
    }

/*    Login Success
    Page Object Model for the login page should be provided.
    Test is able to login successfully.
    Test uses an assertion to make sure User has logged in.*/

    @Test
    public void successScenario(){
        testUtils.enterTextToTextBox(driver,UrlConstants.UsernameId,UrlConstants.User_Name);
        testUtils.enterTextToTextBox(driver,UrlConstants.PasswordId,UrlConstants.Password);
        testUtils.clickButton(driver,UrlConstants.Login_Button_Class);
        assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }

/*    Login Failure

    Page Object Model for the login page should be used.
    Test is not able to login with wrong credentials.
    Test uses assertions to check Login failed for incorrect user and password.*/
    @Test
    public void failWithWrongUserName(){
        testUtils.enterTextToTextBox(driver,UrlConstants.UsernameId,UrlConstants.Wrong_User_Name);
        testUtils.enterTextToTextBox(driver,UrlConstants.PasswordId,UrlConstants.Password);
        testUtils.clickButton(driver,UrlConstants.Login_Button_Class);
        assertTrue(driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
    }

    @Test
    public void failWithWrongPassword(){
        testUtils.enterTextToTextBox(driver,UrlConstants.UsernameId,UrlConstants.User_Name);
        testUtils.enterTextToTextBox(driver,UrlConstants.PasswordId,UrlConstants.Wrong_Password);
        testUtils.clickButton(driver,UrlConstants.Login_Button_Class);
        assertTrue(driver.findElement(By.id("flash")).getText().contains("Your password is invalid!"));
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
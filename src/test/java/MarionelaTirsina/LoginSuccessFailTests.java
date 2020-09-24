package MarionelaTirsina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LoginSuccessFailTests {
    //    String baseUrl ="http://localhost:7080";
    @Before
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl") + "/login");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
//Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!

    @Test
    public void loginSuccessTest(){
//        driver.get(baseUrl + "/login");
        WebElement usernameBox = Driver.getDriver().findElement(By.id("username"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));

        usernameBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword!");
        loginButton.click();

//        LoginPage loginPage = new LoginPage();
//        loginPage.login("tomsmith", "SuperSecretPassword!");

        String expectedMessage = "You logged into a secure area!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.getDriver().findElement(By.id("flash"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    //Login Failure: http://localhost:7080/login Login fail invalid creadentials
    @Test
    public void loginFailureTest(){
//        driver.get(baseUrl + "/login");
        WebElement usernameBox = Driver.getDriver().findElement(By.id("username"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));

//        LoginPage loginPage = new LoginPage();
        usernameBox.sendKeys("fakeName");
        passwordBox.sendKeys("FakePassword!");
        loginButton.click();

        String expectedMessage = "Your username is invalid!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.getDriver().findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}

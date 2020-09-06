package assessmentMkaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LoginSuccessFailTests {
    //    String baseUrl ="http://localhost:7080";
    @BeforeMethod
    public void setUpMethod(){
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/login");
        Driver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
//Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!

    @Test(priority = 1)
    public void loginSuccessTest(){
//        driver.get(baseUrl + "/login");
        WebElement usernameBox = Driver.get().findElement(By.id("username"));
        WebElement passwordBox = Driver.get().findElement(By.id("password"));
        WebElement loginButton = Driver.get().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));

        usernameBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword!");
        loginButton.click();

//        LoginPage loginPage = new LoginPage();
//        loginPage.login("tomsmith", "SuperSecretPassword!");

        String expectedMessage = "You logged into a secure area!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.get().findElement(By.id("flash"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    //Login Failure: http://localhost:7080/login Login fail invalid creadentials
    @Test(priority = 2)
    public void loginFailureTest(){
//        driver.get(baseUrl + "/login");
        WebElement usernameBox = Driver.get().findElement(By.id("username"));
        WebElement passwordBox = Driver.get().findElement(By.id("password"));
        WebElement loginButton = Driver.get().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));

//        LoginPage loginPage = new LoginPage();
        usernameBox.sendKeys("fakeName");
        passwordBox.sendKeys("FakePassword!");
        loginButton.click();

        String expectedMessage = "Your username is invalid!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.get().findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}

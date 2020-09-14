package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SuccessAndFailLogin {
    public SuccessAndFailLogin() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "login");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void loginSuccessTest() {
        WebElement usernameBox = Driver.get().findElement(By.id("username"));
        WebElement passwordBox = Driver.get().findElement(By.id("password"));
        WebElement loginButton = Driver.get().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
        usernameBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword!");
        loginButton.click();
        String expectedMessage = "You logged into a secure area!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.get().findElement(By.id("flash"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginFailureTest() {
        WebElement usernameBox = Driver.get().findElement(By.id("username"));
        WebElement passwordBox = Driver.get().findElement(By.id("password"));
        WebElement loginButton = Driver.get().findElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
        usernameBox.sendKeys("Wrong username");
        passwordBox.sendKeys("Wrong password");
        loginButton.click();
        String expectedMessage = "Your username is invalid!";
        System.out.println("expectedMessage = " + expectedMessage);
        WebElement message = Driver.get().findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));
        String actualMessage = message.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}

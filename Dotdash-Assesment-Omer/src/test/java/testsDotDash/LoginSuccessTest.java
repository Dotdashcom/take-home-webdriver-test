package testsDotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LoginSuccessTest{

    @BeforeMethod
    public void setUpMethod(){
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/login");
        Driver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void loginSuccessTest(){

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

}

package com.task.tests;

import com.task.pages.loginPage;
import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPageUnSuccessfulTest {

    loginPage loginPage = new loginPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/login");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();

    }

    @Test
    public void loginPageTestUnSuccesful (){
        loginPage.userName.sendKeys(ConfigurationReader.getPropery("wrongusername"));
        loginPage.password.sendKeys(ConfigurationReader.getPropery("wrongpassword"));
        loginPage.loginButton.click();

        String actual = "Your username is invalid!\n" + "×";

        Assert.assertEquals( actual , loginPage.expectedMessage.getText() );
    }


}

package com.task.tests;

import com.task.pages.loginPage;
import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class loginPageSuccessfulTest {

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
    public void loginPageTestSuccessful (){
        loginPage.userName.sendKeys(ConfigurationReader.getPropery("username"));
        loginPage.password.sendKeys(ConfigurationReader.getPropery("password"));
        loginPage.loginButton.click();

        String actual = "You logged into a secure area!\n" + "×";

        Assert.assertEquals( actual , loginPage.expectedMessage.getText() );
    }


}

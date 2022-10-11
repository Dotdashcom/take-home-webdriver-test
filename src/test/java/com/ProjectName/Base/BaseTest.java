package com.ProjectName.Base;
import com.ProjectName.pages.LoginPage;
import com.ProjectName.utilities.ConfigurationReader;
import com.ProjectName.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;


    @BeforeTest
    public void setup(){
       driver = Driver.getDriver();

    }

    @AfterTest
    public void tearDown(){
     driver.quit();
    }
}


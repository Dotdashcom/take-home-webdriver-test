package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.NewTabPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabTest extends BasePage {
    public WebDriver driver;
    NewTabPage newTabPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("newTabUrl"));
    }

    @Test
    public void validateNewWindowText() {
        newTabPage= new NewTabPage(driver);
        newTabPage.openNewTabAndVerifyText("New Window");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

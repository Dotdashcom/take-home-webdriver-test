package com.company.tests;

import com.company.pages.DynamicallyLoadedPage1;
import com.company.pages.DynamicallyLoadedPage7;
import com.company.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC09_DynamicLoading {


    @Test
    public void dynamically_load_page_7(){

//        1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        DynamicallyLoadedPage7 dynamicallyLoadedPage7 =new DynamicallyLoadedPage7();

//        2. Wait until title is “Dynamic title”

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

//        3. Assert:
//        Message “Done” is displayed.

        Assert.assertEquals(dynamicallyLoadedPage7.doneMsg.getText(),"Done!");

//        4. Assert: Image is displayed.
        Assert.assertTrue(dynamicallyLoadedPage7.image.isDisplayed());
    }

    @Test
    public void dynamically_load_page_1(){
        //    1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        DynamicallyLoadedPage1 dynamicallyLoadedPage1 = new DynamicallyLoadedPage1();

//            2. Click to start
        dynamicallyLoadedPage1.startBtn.click();

//3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(dynamicallyLoadedPage1.loadingBar));

        //BrowserUtils.waitForInvisibilityOf(dynamicallyLoadedPage1.loadingBar);

//4. Assert username input box is displayed
        Assert.assertTrue(dynamicallyLoadedPage1.userName.isDisplayed());


//5. Enter username: tomsmith
        dynamicallyLoadedPage1.userName.sendKeys("tomsmith");


//6. Enter password: incorrectpassword
        dynamicallyLoadedPage1.password.sendKeys("incorrectpassword");


//7. Click to Submit button
        dynamicallyLoadedPage1.submitBtn.click();


//8. Assert “Your password is invalid!” text is displayed.

        Assert.assertTrue(dynamicallyLoadedPage1.errorMsg.isDisplayed());

    }
}

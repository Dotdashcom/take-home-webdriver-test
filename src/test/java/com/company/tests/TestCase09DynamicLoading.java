package com.company.tests;

import com.company.pages.DynamicallyLoadedPage2;
import com.company.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test clicks the start button and uses explicit wait.
 * Test asserts that “Hello World!” text is displayed.
 */

public class TestCase09DynamicLoading {

    @Test
    public void dynamically_load_page_2() {

        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

        DynamicallyLoadedPage2 dynamicallyLoadedPage2 = new DynamicallyLoadedPage2();

        dynamicallyLoadedPage2.StartButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dynamicallyLoadedPage2.HelloWorld));

        Assert.assertEquals(dynamicallyLoadedPage2.HelloWorld.getText(), "Hello World!");

        Driver.closeDriver();
    }
}
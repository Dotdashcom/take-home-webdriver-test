package com.dotdash.tests;

import com.dotdash.pages.DynamicControlsPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsTest extends TestBase {


    @Test
    public void dynamicControlsTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.navigatePages("Dynamic Controls");

        dynamicControlsPage.firstBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.text1));

        Assertions.assertEquals("It's gone!", dynamicControlsPage.text1.getText());

        dynamicControlsPage.firstBtn.click();

        Assertions.assertEquals("It's back!", dynamicControlsPage.text1.getText());

        dynamicControlsPage.secondBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.text1));

        Assertions.assertEquals("It's enabled!", dynamicControlsPage.text1.getText());

        dynamicControlsPage.secondBtn2.click();

        Assertions.assertEquals("It's disabled!", dynamicControlsPage.text1.getText());



    }

}

package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.pages.DynamControlsPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_08_DynamicControls extends TestBase {
    @Test
    public void dynamic_controls_test() {
        DynamControlsPage dynamicControlsPage = new DynamControlsPage();
        dynamicControlsPage.navigatePages("Dynamic Controls");

        dynamicControlsPage.firstBtn.click();
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 5);
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

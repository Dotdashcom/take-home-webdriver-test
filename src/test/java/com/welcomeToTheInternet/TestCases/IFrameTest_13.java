package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.IFramePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest_13 extends BaseClass {

    @Test
    public void IFramePageTest() {
        driver.get(baseURL);
        IFramePage iFramePage = new IFramePage(driver);

        iFramePage.clickFramePageLink();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Frames");
        iFramePage.clickIFramesPage();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
        iFramePage.closeAlert();
        iFramePage.editText();
        iFramePage.checkText(); // assertion in the IFramePage class.
    }
}

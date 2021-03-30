package com.DotDash.Scripts;

import com.DotDash.Pages.MouseHoverPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;

import java.util.concurrent.TimeUnit;

public class Mousehover extends basePage {

    @Test
    public void mouseHover() throws InterruptedException {
        driver.get(baseURL + "/hovers");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);

        Actions act = new Actions(driver);

        SoftAssert assertion = new SoftAssert();


        act.moveToElement(mouseHoverPage.img1).build().perform();
        assertion.assertTrue(mouseHoverPage.caption1.isDisplayed());

        act.moveToElement(mouseHoverPage.img2).build().perform();
        assertion.assertTrue(mouseHoverPage.caption2.isDisplayed());

        act.moveToElement(mouseHoverPage.img3).build().perform();
        assertion.assertTrue(mouseHoverPage.caption3.isDisplayed());

        assertion.assertAll();

    }
}

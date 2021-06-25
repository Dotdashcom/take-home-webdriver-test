package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import utilities.EndPoints;

public class MouseHover extends TestBase {


    @Test
    public void testMouseHover() {
        MouseHoverPage mhp = new MouseHoverPage();
        extentTest = extentReports.createTest("Mouse Hover Test");
        mhp.navigateTo(EndPoints.HOVERS);
        extentTest.info("Navigate to Mouse Hover Page");

        Actions hover = new Actions(mhp.driver);

        hover.moveToElement(mhp.img1).perform();
        extentTest.info("Mouse is Hovered to First Image");

        Assert.assertTrue(mhp.showText1.isDisplayed());
        extentTest.info("After Hovering Image1's Text Become Visible => "+mhp.showText1.getText());

        hover.moveToElement(mhp.img2).perform();
        extentTest.info("Mouse is Hovered to Second Image");

        Assert.assertTrue(mhp.showText2.isDisplayed());
        extentTest.info("After Hovering Image2's Text Become Visible => "+mhp.showText2.getText());

        hover.moveToElement(mhp.img3).perform();
        extentTest.info("Mouse is Hovered to Third Image");

        Assert.assertTrue(mhp.showText3.isDisplayed());
        extentTest.info("After Hovering Image3's Text Become Visible => "+mhp.showText3.getText());
        extentTest.pass("Mouse Hover Test is Successful");


    }
}

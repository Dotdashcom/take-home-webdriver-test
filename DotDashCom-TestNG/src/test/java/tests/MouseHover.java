package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MouseHover {

    MouseHoverPage mouseHoverPage = new MouseHoverPage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"hovers");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(mouseHoverPage.img1).perform();
        Assert.assertTrue(mouseHoverPage.text1.isDisplayed());
        actions.moveToElement(mouseHoverPage.img2).perform();
        Assert.assertTrue(mouseHoverPage.text2.isDisplayed());
        actions.moveToElement(mouseHoverPage.img3).perform();
        Assert.assertTrue(mouseHoverPage.text3.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

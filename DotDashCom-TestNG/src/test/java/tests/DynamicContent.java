package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class DynamicContent extends TestBase {

    DynamicContentPage dynamicContentPage = new DynamicContentPage();
    @Test()
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"dynamic_content");
        String expectedimg1 = dynamicContentPage.img1.getText();
        String expectedimg2 = dynamicContentPage.img2.getText();
        String expectedimg3 = dynamicContentPage.img3.getText();
        String expectedtext1 = dynamicContentPage.text1.getText();
        String expectedtext2 = dynamicContentPage.text2.getText();
        String expectedtext3 = dynamicContentPage.text3.getText();
        for (int i = 0; i < 2; i++) {
        dynamicContentPage.clickHere.click();
        String actualimg1 = dynamicContentPage.img1.getText();
        String actualimg2 = dynamicContentPage.img2.getText();
        String actualimg3 = dynamicContentPage.img3.getText();
        String actualtext1 = dynamicContentPage.text1.getText();
        String actualtext2 = dynamicContentPage.text2.getText();
        String actualtext3 = dynamicContentPage.text3.getText();

        Assert.assertNotEquals(actualimg1,expectedimg1);
        Assert.assertNotEquals(actualtext1,expectedtext1);
        Assert.assertNotEquals(actualimg2,expectedimg2);
        Assert.assertNotEquals(actualtext2,expectedtext2);
        Assert.assertNotEquals(actualimg3,expectedimg3);
        Assert.assertNotEquals(actualtext3,expectedtext3);
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

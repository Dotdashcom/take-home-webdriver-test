package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckBoxesPage;
import pages.DynamicContentPage;
import pages.HomePage;

public class DynamicContentTest extends BaseTest{
    @Test
    public void verifyDynamicContent(){
        HomePage homePage= new HomePage(driver);
        DynamicContentPage dynamicContentPage = homePage.clickDynamicContent();
        SoftAssert softAssert = new SoftAssert();
        String text1Before= dynamicContentPage.getColumnOneFieldText();
        String text2Before= dynamicContentPage.getColumnTwoFieldText();
        String text3Before= dynamicContentPage.getColumnThreeFieldText();
        dynamicContentPage.clickOnClickHere();
        String text1After= dynamicContentPage.getColumnOneFieldText();
        String text2After= dynamicContentPage.getColumnTwoFieldText();
        String text3After= dynamicContentPage.getColumnThreeFieldText();
        softAssert.assertNotEquals(text1Before,text1After);
        softAssert.assertNotEquals(text2Before,text2After);
        softAssert.assertNotEquals(text3Before,text3After);
        softAssert.assertAll();

    }
}

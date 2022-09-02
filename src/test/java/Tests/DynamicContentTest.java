package Tests;

import Pages.BasePage;
import Pages.DynamicContentPage;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.Test;
import utilities.Driver;
import utilities.EndPoints;

import static Tests.TestBase.extentReports;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.dc;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicContentTest {

    String baseURL="http://localhost:7080";

    @Test
    public void DynamicContent() {
        ExtentTest extentTest;

        DynamicContentPage dc=new DynamicContentPage();

        Driver.getDriver().get(baseURL+"/dynamic_content");
        extentTest = extentReports.createTest("Dynamic Content");
        extentTest.info("Navigate Dynamic Content Page");
        dc.navigateTo(EndPoints.DYNAMICCONTENT);



        String img1 = dc.img1.getAttribute("src");
        String img2 = dc.img2.getAttribute("src");
        String img3 = dc.img3.getAttribute("src");

        String text1 = dc.text1.getText();
        String text2 = dc.text2.getText();
        String text3 = dc.text3.getText();

        extentTest.info("Before Refresh");
        dc.driver.navigate().refresh();
        extentTest.info("After Refresh");

        String newImg1 = dc.img1.getAttribute("src");
        String newImg2 = dc.img2.getAttribute("src");
        String newImg3 = dc.img3.getAttribute("src");

        String newText1 = dc.text1.getText();
        String newText2 = dc.text2.getText();
        String newText3 = dc.text3.getText();


        assertNotEquals(newImg1, img1);
        assertNotEquals(newImg2, img2);
        assertNotEquals(newImg3, img3);
        extentTest.info("Image Assertions are Verified");

        assertNotEquals(newText1, text1);
        assertNotEquals(newText2, text2);
        assertNotEquals(newText3, text3);
        extentTest.info("Text Assertions are Verified");



        extentTest.pass("Dynamic Content Test is Successful");



        Driver.getDriver().navigate().refresh();
    }
}

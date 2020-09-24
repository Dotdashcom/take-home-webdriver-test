package MarionelaTirsina;

import MarionelaTirsina.pages.DynamicContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicContentTest {
    /**
     * Dynamic Content: http://localhost:7080/dynamic_content
     *      Test content changes with page reload.
     */
    DynamicContent dynamicContent=new DynamicContent();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dynamic_content");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void dynamicContent() {

        WebElement image1 = dynamicContent.image1;
        String image1Value = image1.getAttribute("src");
        System.out.println("image1Value = " + image1Value);

        WebElement image2 =dynamicContent.image2;
        String image2Value = image2.getAttribute("src");
        System.out.println("image2Value = " + image2Value);

        WebElement image3 = dynamicContent.image3;
        String image3Value = image3.getAttribute("src");
        System.out.println("image3Value = " + image3Value);

        String getText1 =dynamicContent.text1.getText();
        System.out.println("getText1 = " + getText1);
        String getText2 = dynamicContent.text2.getText();
        System.out.println("getText2 = " + getText2);
        String getText3 =dynamicContent.text3.getText();
        System.out.println("getText3 = " + getText3);

        WebElement clickHereLink = dynamicContent.clickHERE;
        clickHereLink.click();

        WebElement image4 = dynamicContent.image4;
        String image4Value = image4.getAttribute("src");
        System.out.println("image4Value = " + image4Value);

        WebElement image5=dynamicContent.image5;
        String imag5Value = image5.getAttribute("src");
        System.out.println("imag5Value = " + imag5Value);

        WebElement image6 = dynamicContent.image6;
        String image6Value = image6.getAttribute("src");
        System.out.println("image6Value = " + image6Value);



        String getText4 =dynamicContent.text4.getText();
        System.out.println("getText4 = " + getText4);
        String getText5 = dynamicContent.text5.getText();
        System.out.println("getText5 = " + getText5);
        String getText6 = dynamicContent.text6.getText();
        System.out.println("getText6 = " + getText6);


        Assert.assertFalse(
                image1Value.contains(image4Value) && (image2Value.contains(image4Value)
                        && (image3Value.contains(image4Value) && getText1.contains(getText4) && (getText2.contains(getText5) && getText3.contains(getText6)))));
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }

}

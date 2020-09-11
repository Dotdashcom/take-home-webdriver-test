package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicContentTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/dynamic_content");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void dynamicContent() {

        WebElement img0 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image0Value = img0.getAttribute("src");
        System.out.println("image1Value = " + image0Value);

        WebElement img1 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image1Value = img1.getAttribute("src");
        System.out.println("image2Value = " + image1Value);

        WebElement img2 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image2Value = img2.getAttribute("src");
        System.out.println("image3Value = " + image2Value);

        String txt0 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[1]")).getText();
        System.out.println("text0 = " + txt0);
        String txt1 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[2]")).getText();
        System.out.println("text1 = " + txt1);
        String txt2 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[3]")).getText();
        System.out.println("text2 = " + txt2);

        WebElement clickHereLink = Driver.get().findElement(By.xpath("//a[contains(text(), 'click here')]"));
        clickHereLink.click();

        WebElement image01 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image01Value = image01.getAttribute("src");
        System.out.println("image01Value = " + image01Value);

        WebElement image02 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image02Value = image02.getAttribute("src");
        System.out.println("image02Value = " + image02Value);

        WebElement image03 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        String image03Value = image03.getAttribute("src");
        System.out.println("image33Value = " + image03Value);


        String txt44 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[1]")).getText();
        System.out.println("text11 = " + txt44);
        String text22 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[2]")).getText();
        System.out.println("text22 = " + text22);
        String text33 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[3]")).getText();
        System.out.println("text33 = " + text33);

        Assert.assertFalse(
                image0Value.contains(image01Value) && (image1Value.contains(image02Value)
                        && (image2Value.contains(image03Value) &&
                        txt0.contains(txt44) && (txt44.contains(text22) && txt2.contains(text33)
                        ))));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

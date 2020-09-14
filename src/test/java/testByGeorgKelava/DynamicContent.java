package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicContent {
    public DynamicContent() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "dynamic_content");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void dynamicContent() {
        WebElement image1 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        WebElement image2 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        WebElement image3 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));


        String image1Value = image1.getAttribute("src");
        String image2Value = image2.getAttribute("src");
        String image3Value = image2.getAttribute("src");


        System.out.println("image1Value = " + image1Value);
        System.out.println("image2Value = " + image2Value);
        System.out.println("image3Value = " + image3Value);


        String text1 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[1]")).getText();
        String text2 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[2]")).getText();
        String text3 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[3]")).getText();

        System.out.println("text1 = " + text1);
        System.out.println("text2 = " + text2);
        System.out.println("text3 = " + text3);

        WebElement clickHereLink = Driver.get().findElement(By.xpath("//a[contains(text(), 'click here')]"));
        clickHereLink.click();

        WebElement image11 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        WebElement image22 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));
        WebElement image33 = Driver.get().findElement(By.xpath("(//div[@class=\"large-2 columns\"])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]"));

        String image11Value = image11.getAttribute("src");
        String image22Value = image22.getAttribute("src");
        String image33Value = image33.getAttribute("src");

        System.out.println("image11Value = " + image11Value);
        System.out.println("image22Value = " + image22Value);
        System.out.println("image33Value = " + image33Value);


        String text11 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[1]")).getText();
        String text22 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[2]")).getText();
        String text33 = Driver.get().findElement(By.xpath("(//div[@class=\"large-10 columns\"])[3]")).getText();

        System.out.println("text1 = " + text1);
        System.out.println("text22 = " + text22);
        System.out.println("text33 = " + text33);

        Assert.assertFalse(image1Value.contains(image11Value) && image2Value.contains(image22Value) && image3Value.contains(image33Value) && text1.contains(text1) && text2.contains(text22) && text3.contains(text33));
    }
}

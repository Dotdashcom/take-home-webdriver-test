package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FloatingMenu {
    public FloatingMenu() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "floating_menu");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }



    @Test
    public void floatingMenuTest() {
        WebElement homeButton = Driver.get().findElement(By.cssSelector("a[href=\"#home\"]"));
        homeButton.click();
        String expectedHomeButtonTxt = "Home";
        String actualHomeButtonTxt = homeButton.getText();
        WebElement newsButton = Driver.get().findElement(By.cssSelector("a[href=\"#news\"]"));
        newsButton.click();
        String expectedNewsButtonTxt = "News";
        String actualNewsButtonTxt = newsButton.getText();
        WebElement contactButton = Driver.get().findElement(By.cssSelector("a[href=\"#contact\"]"));
        contactButton.click();
        String expectedContactButtonTxt = "Contact";
        String actualContactButtonTxt = contactButton.getText();
        WebElement aboutButton = Driver.get().findElement(By.cssSelector("a[href=\"#about\"]"));
        aboutButton.click();
        String expectedAboutButtonTxt = "About";
        String actualAboutButtonTxt = aboutButton.getText();
        Assert.assertEquals(expectedHomeButtonTxt, actualHomeButtonTxt);
        Assert.assertEquals(expectedNewsButtonTxt, actualNewsButtonTxt);
        Assert.assertEquals(expectedContactButtonTxt, actualContactButtonTxt);
        Assert.assertEquals(expectedAboutButtonTxt, actualAboutButtonTxt);
    }
}

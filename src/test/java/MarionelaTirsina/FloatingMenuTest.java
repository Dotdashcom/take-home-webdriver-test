package MarionelaTirsina;

import MarionelaTirsina.pages.FloatingMenu;
import groovy.transform.Undefined;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FloatingMenuTest {
    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    FloatingMenu floatingMenu=new FloatingMenu();
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/floating_menu");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void floatingMenuTest(){
        WebElement homeButton =floatingMenu.homeButton;
        homeButton.click();
        String expectedHomeButtonText = "Home";
        String actualHomeButtonText = homeButton.getText();

        WebElement newsButton = floatingMenu.newsButton;
        newsButton.click();
        String expectedNewsButtonText = "News";
        String actualNewsButtonText = newsButton.getText();

        WebElement contactButton = floatingMenu.contactButton;
        contactButton.click();
        String expectedContactButtonText = "Contact";
        String actualContactButtonText = contactButton.getText();

        WebElement aboutButton = floatingMenu.aboutButton;
        aboutButton.click();
        String expectedAboutButtonText = "About";
        String actualAboutButtonText = aboutButton.getText();

        Assert.assertEquals(expectedAboutButtonText,actualAboutButtonText);
        Assert.assertEquals(expectedNewsButtonText,actualNewsButtonText);
        Assert.assertEquals(expectedContactButtonText,actualContactButtonText);
        Assert.assertEquals(expectedAboutButtonText,actualAboutButtonText);
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }
}

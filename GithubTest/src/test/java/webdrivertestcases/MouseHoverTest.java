package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.LoginSuccess;
import webdrivertestpages.MouseHover;

/*
 * For mouse hover I am using Actions class of Selenium Webdriver.
 * First, I instantiated Actions class by passing driver to its constructor.
 * Then I invoked moveToElement() method by passing the target element.
 * Finally, I used build() and perform() method execute all steps.
 *
 * */

public class MouseHoverTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/hovers");
    }

    @Test
    public void mouseHover(){
        MouseHover mv = new MouseHover(driver);
        mv.mouseHover();
        Assert.assertTrue(mv.isHoverDisplay());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

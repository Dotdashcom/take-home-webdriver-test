package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.CheckAndUncheck;

public class CheckAndUncheckTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get(baseURI + "/checkboxes");
    }

    @Test
    public void checkUncheckBox(){
        CheckAndUncheck ck = new CheckAndUncheck(driver);
        ck.checkClick();
        Assert.assertTrue(ck.isCheck());
        ck.uncheckClick();
        Assert.assertTrue(ck.isUncheck());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

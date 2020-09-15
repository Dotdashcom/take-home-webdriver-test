package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.MouseHover;
import webdrivertestpages.NewsTab;

public class NewTabTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/windows");
    }

    @Test
    public void newTab(){
        NewsTab nt = new  NewsTab(driver);
        nt.newsTab();
        Assert.assertEquals(nt.getNewTabURL(), "http://localhost:7080/windows/new");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

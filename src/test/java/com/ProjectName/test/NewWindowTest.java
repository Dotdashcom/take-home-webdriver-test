package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class NewWindowTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/windows");
    }

    @Test
    public void newWindowsTest(){

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        it.next();
        driver.switchTo().window(it.next());

        String actualText = driver.getTitle();
        String expectedText ="New Window";
        Assert.assertEquals(actualText, expectedText);



    }
}

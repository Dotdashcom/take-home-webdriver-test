package com.homewebdriver.test;

import com.homewebdriver.webpages.DragAndDropPage;
import com.homewebdriver.webpages.DropdownPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DropdownTest {

    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropDownFunc() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectValueFromDropdown("Index");
        dropdownPage.selectValueFromDropdown("Text");
        dropdownPage.selectValueFromDropdown("Value");
    }

    @After
    public void close(){
        driver.close();
    }
}

package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage{


    @FindBy(id = "dropdown")
    private WebElement dropdownInput;

    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/dropdown");
    }

    @Test
    public void selectOption1(){
        Select select = new Select(dropdownInput);
          select.selectByVisibleText("Option 1");
          String option1 = select.getFirstSelectedOption().getText();
        Assert.assertTrue(option1.contains("Option 1"));
        System.out.println("-> selected option is: " + option1);

    }

    @Test
    public void selectOption2(){
        Select select = new Select(dropdownInput);
        select.selectByVisibleText("Option 2");
        String option2 = select.getFirstSelectedOption().getText();
        Assert.assertTrue(option2.contains("Option 2"));
        System.out.println("-> selected option is: " + option2);
    }


    @AfterClass
    public static  void tearDown(){
        DriverTest.getDriver().close();
    }
}

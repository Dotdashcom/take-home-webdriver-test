package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdown extends TestBase{

    @FindBy(id = "dropdown")
    WebElement Menu;

    public dropdown() {
        PageFactory.initElements(driver, this);
    }

    public void dropDownMenu() {

        Select select = new Select(Menu);


        select.selectByVisibleText("Option 1");

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

}

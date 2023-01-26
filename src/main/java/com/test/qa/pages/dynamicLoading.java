package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class dynamicLoading extends TestBase {

    @FindBy(xpath= "//*[@id=\"start\"]/button")
    WebElement start_button;
    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    WebElement text;


    public dynamicLoading () {
        PageFactory.initElements(driver, this);
    }

    public void loading() {

        start_button.click();
       // wait.until(ExpectedConditions.visibilityOf(text));
        //WaitFor_present(driver, Duration.ofSeconds(5), text, "Hello World!");
        Assert.assertEquals(text.getText(), "Hello World!", "wrong");
    }
}


package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class iFrame extends TestBase{

    @FindBy (id = "mce_0_ifr")
    WebElement frameBox;

    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement textBox;

    public iFrame() {
        PageFactory.initElements(driver, this);
    }

    public void frame() {

        driver.switchTo().frame((frameBox));
        textBox.clear();
        String textToType="Iframe Test in box";
        textBox.sendKeys(textToType);
        Assert.assertEquals((textBox).getText().trim(), textToType);
    }
}

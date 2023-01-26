package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class contextMenu extends TestBase {

    @FindBy(id = "hot-spot")
    WebElement contextLoc;


    public contextMenu() {
        PageFactory.initElements(driver, this);

    }

    public void context() {


        Actions context = new Actions(driver);
        context.contextClick(contextLoc).build().perform();
        String Actual_Alert_text = driver.switchTo().alert().getText();
        String Expected_Alert_text = "You selected a context menu";
        if (Actual_Alert_text.contains(Expected_Alert_text)) {
            driver.switchTo().alert().accept();
            Assert.assertTrue(true);
        }else

            Assert.assertTrue(false);

    }

}


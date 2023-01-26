package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class dynamicContent extends TestBase{

    @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
    WebElement image1;


    @FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
    WebElement image2;


    public dynamicContent () {
        PageFactory.initElements(driver, this);
    }

    public void dynaContact() {

        //Content before refresh

        String text1BeforeRefresh=(image1).getText();
        String text2BeforeRefresh=(image2).getText();

        // refresh page
        driver.navigate().refresh();

        //after refresh get content

        String text1AfterRefresh_1=(image1).getText();
        String text2AfterRefresh_1=(image2).getText();
        Assert.assertEquals(text1AfterRefresh_1.contains(text1BeforeRefresh), false);
        Assert.assertEquals(text2AfterRefresh_1.contains(text2BeforeRefresh), false);

        // Second time refresh the page
        driver.navigate().refresh();


        String text1AfterRefresh_2=(image1).getText();
        String text2AfterRefresh_2=(image2).getText();

        Assert.assertEquals(text1AfterRefresh_1.contains(text1AfterRefresh_2), false);
        Assert.assertEquals(text2AfterRefresh_1.contains(text2AfterRefresh_2), false);
    }

}


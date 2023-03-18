package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContentPage {
    public WebDriver driver;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@id='content']/div[1]/div[2]")
    public WebElement firstContent;

    @FindBy(xpath="//div[@id='content']/div[2]/div[2]")
    public WebElement secondContent;

    @FindBy(xpath="//div[@id='content']/div[3]/div[2]")
    public WebElement thirdContent;

    public void refreshPage(int count)  {

        for(int i=0; i<count; i++) {
            String fcTextOld = firstContent.getText();
            String scTextOld = secondContent.getText();
            String tcTextOld = thirdContent.getText();
            driver.navigate().refresh();
            Assert.assertNotEquals(firstContent.getText(), fcTextOld);
            Assert.assertNotEquals(secondContent.getText(), scTextOld);
            Assert.assertNotEquals(thirdContent.getText(), tcTextOld);
        }
    }
}

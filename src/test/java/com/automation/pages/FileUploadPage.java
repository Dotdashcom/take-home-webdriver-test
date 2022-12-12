package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUploadPage extends BasePage{

    @FindBy(xpath = "//a[@href='/upload']")
    WebElement link;

    @FindBy(id = "file-upload")
    WebElement chooseFileInput;

    @FindBy(xpath = "//div[@class='example']/h3")
    WebElement text;

    public void clickOnLink(){
        link.click();
    }
    public void upload(){
       chooseFileInput.sendKeys("C:\\Users\\Asus\\OneDrive\\Рабочий стол\\resume.pdf");
        Assert.assertTrue(text.isDisplayed());
    }
}

package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadPage extends BasePage {

    private final By uploadLink = By.id("file-upload");
    private final By submitButton = By.id("file-submit");

    public FileUploadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("file_upload_url"));
    }

    public void file_upload(){
        String rootPath = System.getProperty("user.dir");

        findElement(uploadLink).sendKeys(rootPath + "/" + "testng.xml");

        findElement(submitButton).click();

        Assert.assertEquals(pageSourceVerify("File Uploaded!"),true );

    }
}

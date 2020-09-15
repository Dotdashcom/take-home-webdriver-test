package webdrivertestpages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FileUpload extends Base {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement fileUpload;
    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement submit;

    public FileUpload(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fileUpload(String filePath){
        fileUpload.sendKeys(filePath);
        submit.click();

    }

}

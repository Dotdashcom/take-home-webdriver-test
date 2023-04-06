package com.homewebdriver.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    static WebDriver driver;

    private static String FILE_UPLOAD_URL="http://localhost:7080/upload";

    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement uploadButton;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    public WebElement uploadedFileText;

    @FindBy(xpath = "//div[@id='uploaded-files']/preceding-sibling::h3")
    public WebElement uploadedFileSuccessMessage;



    public FileUploadPage(WebDriver driver){
        this.driver=driver;
        driver.get(FILE_UPLOAD_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickFileLinkToUpload() throws InterruptedException {
        String path = System.getProperty("user.dir");
        chooseFileButton.sendKeys(path+"\\files\\some-file.txt");
        Thread.sleep(3000);
    }
    public void clickUploadButton() {
        uploadButton.click();
    }
    public String getUploadedFileText() {
       return uploadedFileText.getText();

    }
    public String getUploadedSuccessMessage() {
        return uploadedFileSuccessMessage.getText();
    }
}

package com.example.cucumber.page.fileUpload;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.example.constants.Page.FILE_UPLOAD_PAGE;
import static com.example.constants.PageLinkText.FILE_UPLOAD;
import static com.example.constants.UtilConstants.FILE_UPLOAD_PATH;
import static org.junit.Assert.assertEquals;

public class FileUploadPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public FileUploadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By file_upload_page_link = By.linkText(FILE_UPLOAD);
    private By file_upload_submit_id = By.id("file-submit");
    public void the_user_clicks_on_file_upload_page() {
        clckOnWebElement(file_upload_page_link);
    }

    public void the_user_should_see_the_file_upload_page() {
        assertEquals("File Upload Page URL doesn't Match: ", FILE_UPLOAD_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_upload_a_test_file_on_the_file_upload_page() {
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        waitForMilliSeconds(2000);
        String filePath = FILE_UPLOAD_PATH;
        fileInput.sendKeys(filePath);
        waitForMilliSeconds(1000);
        clckOnWebElement(file_upload_submit_id);
        waitForMilliSeconds(5000);
    }

    public void the_user_should_see_the_file_is_uploaded_on_the_file_upload_page() {
        By fileUploadSuccessMsgXpath = By.xpath("//h3[contains(text(),'File Uploaded!')]");
        assertEquals("File upload success message not correct: ", "File Uploaded!",getWebElementText(fileUploadSuccessMsgXpath));
    }
}

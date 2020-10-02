package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileUploadRepository extends TestEngine {

    //parameterized constructor
    public FileUploadRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

        @FindBy(how = How.ID, using = "file-upload")
        public WebElement _chooseFile;

        @FindBy(how = How.XPATH, using = "//input[@class='button' and @value='Upload']")
        public WebElement _uploadFile;

        @FindBy(how = How.XPATH, using = "//h3[text()='File Uploaded!']")
        public WebElement _fileUploadedSuccessfully;

        public static String _uploadFilePath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Downloads\\some-file.txt";

        public void ChooseAndUploadFile(){
            _chooseFile.sendKeys(_uploadFilePath);
            _uploadFile.click();
            SeleniumCommonMethods.WaitUntilElementAppears(_fileUploadedSuccessfully);
        }

        public boolean IsFileUploaded(){
            return _fileUploadedSuccessfully.isDisplayed();
        }
}

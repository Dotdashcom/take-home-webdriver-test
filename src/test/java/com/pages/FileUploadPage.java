package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends BaseClass {

    public FileUploadPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//input[@id='file-upload']")
    public WebElement _chooseFileButton;

    @FindBy(how = How.ID, using =  "file-submit")
    public WebElement _uploadButton;

    @FindBy(how = How.XPATH, using =  "//div[@id='uploaded-files']")
    public WebElement _uploadedFileName;


    public static String _filePath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Download\\some-file.txt";


    public void  FileUpload(){
        _chooseFileButton.sendKeys(_filePath);

    }

    public void ClickUploadButton() throws InterruptedException {
        _uploadButton.click();
        CommonMethods.Wait_ajax();
    }





}

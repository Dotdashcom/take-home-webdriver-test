package com.tests.pages;

import com.tests.util.DriverTest;
import com.tests.util.ScreenShotTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {


    @FindBy(id = "file-upload")
    private WebElement chooseFileButtonInput;

    @FindBy(id = "file-submit")
    private WebElement uploadButtonInput;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesInput;


    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get(" http://localhost:7080/upload ");
    }


    @Test
    public void uploadAFile() throws Exception {
        waitForVisibilityOf(chooseFileButtonInput);
        String filePath = "C:\\Users\\gokha\\Downloads\\some-file.txt";
        chooseFileButtonInput.sendKeys(filePath);
        uploadButtonInput.click();
        System.out.println("-> Uploaded file is: " + uploadedFilesInput.getText());
        ScreenShotTest.takeScreenShot("uploadedFile");
    }



    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}

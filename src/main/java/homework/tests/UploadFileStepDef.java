package homework.tests;

import homework.pages.UploadPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadFileStepDef extends TestBase {

    UploadPage uploadPage = new UploadPage();

    @Test
    public void uploadFunctionality(){

        Driver.getDriver().get("http://localhost:7080/upload");

        uploadPage.chooseFileButton.sendKeys("/Users/jelena/Downloads/some-file.txt");

        uploadPage.uploadButton.click();

        Assert.assertTrue(uploadPage.uploadedFiles.isDisplayed());

    }


}

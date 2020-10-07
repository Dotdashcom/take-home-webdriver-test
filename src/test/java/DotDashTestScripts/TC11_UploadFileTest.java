package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.UploadPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Testcase Description: File Upload: http://localhost:7080/upload Test File Upload.
public class TC11_UploadFileTest extends baseClass {

    @Test
    public void uploadFile() throws InterruptedException {
        //Launch url
        driver.get(baseURL+"/upload");

        //Create an object of UploadPage
        UploadPage uploadPage = new UploadPage(driver);

        //Actions class to click on Choose file
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.ENTER);

        //Send the file to upload
        uploadPage.btnChoosefile.sendKeys("C:\\Users\\kruti\\Downloads\\some-file.txt");

        //Click on the upload button
        uploadPage.clkbtnUpload();

        Thread.sleep(2000);

        //Validate whether the file is uploaded successfully
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(uploadPage.gettxtFileUpload(),"File Uploaded!");

        assertion.assertAll();
    }
}

package specs.FileUpload;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #11 File Upload: http://localhost:7080/upload Test File Upload
public class CheckFileUpload extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static By byUploadFile = By.xpath("//input[@id='file-upload']");
    private static By byUploadBtn = By.xpath("//input[@id='file-submit']");
    private static By byUploadedFiles = By.xpath("//div[@id='uploaded-files']");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/upload");
    }

    @Test
    public void checkFileUpload() throws Exception {
        SoftAssert softas = new SoftAssert();

        driver.findElement(byUploadFile).sendKeys(System.getProperty("user.home")+"/Downloads/some-file.txt");

        driver.findElement(byUploadBtn).click();
        Thread.sleep(DEFAULT_PAUSE);

        String actResult = driver.findElement(byUploadedFiles).getText();

        softas.assertTrue(actResult.contains("some-file.txt"), "File uploading failed");

        softas.assertAll();
    }

}

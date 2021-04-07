package File;

import Pages.FileDownloadPage;
import Pages.FileUploadPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class FileUploadTest extends TestBase {
    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/upload"));
    }
    @Test
    public void FileUploadtest() {

        FileUploadPage fu=new FileUploadPage();
        String path=System.getProperty("user.home")+"/desktop/test.txt";
        fu.choosefile.sendKeys(path);
        fu.submit.click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());

    }
}


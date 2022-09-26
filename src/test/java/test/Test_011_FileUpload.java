package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_011_FileUpload extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/upload");
    }

    @Test
    public void TC001_FileUploadTesting() {
        fu.getChooseFileBtn().sendKeys("/Users/thunpanchatsurachai/Downloads/1080269.png");
        fu.uploadButton().click();
        String confirmedText = fu.getConfirmText().getText();
        Assert.assertTrue(confirmedText.contains("Uploaded"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}

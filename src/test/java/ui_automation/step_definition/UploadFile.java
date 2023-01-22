package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.DynamicContent;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import ui_automation.pages.UploadFilePage;

public class UploadFile {

    WebDriver driver = Driver.getDriver();
    UploadFilePage page = new UploadFilePage(driver);

    @Given("User navigate to the URL")
    public void user_navigate_to_the_URL() {
        String uploadFile = (ConfigurationReder.getProperties("ui-config.properties", "uploadFile"));
        driver.get(uploadFile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("user upload the file in the web Page and verrify iploading successful")
    public void user_upload_the_file_in_the_web_Page_and_verrify_iploading_successful() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData/selenium.pmh.png";
        page.chooseFile.sendKeys(filePath);
        page.uploadBtn.click();
        String fileName = "selenium.pmh.png";
        String fileUploaded = page.veriffyUploadedFile.getText();
        Assert.assertEquals(fileName, fileUploaded);
//        System.out.println("file Name : " + fileName);
//        System.out.println("FileUploaded: " + fileUploaded);


    }

    @Then("user should close driver")
    public void user_should_close_driver() {
        Driver.closeDriver();

    }
}

package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui_automation.pages.DownlaodFilePage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DownloadFile {


    WebDriver driver = Driver.getDriver();
    DownlaodFilePage page = new DownlaodFilePage(driver);

    @Given("User navigate to the file Download URL")
    public void user_navigate_to_the_file_Download_URL() {

        String downloadURL = (ConfigurationReder.getProperties("ui-config.properties", "downloadURL"));
        driver.get(downloadURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("user click on the filr {string} to TestData folder under resources")
    public void user_click_on_the_filr_to_TestData_folder_under_resources(String expectedFile) throws InterruptedException, IOException {

     page.file.click();
     Thread.sleep(2000);
        String path = "src/test/resources/TestData/Download";

        File directoryPath = new File(path);
        String contents[] = directoryPath.list();
        for(int i=0; i<contents.length; i++) {
            Assert.assertEquals(expectedFile, contents[i]);
        }
        File file = new File(path +"/"+ expectedFile);
        if(file.exists()){
            file.delete();
        }




    }


    @Then("user close driver")
    public void user_close_driver() {

    }
}

package dot.dash.step_definitions;

import dot.dash.utilities.ConfigReader;
import dot.dash.utilities.Driver;
import dot.dash.utilities.WaitUntil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadFile_steps {
    WebDriver driver = null;
    String fileName = "some-file.txt";
    String path = "";

    @Given("user is in {string} page")
    public void user_is_in_page(String subDomain) {
        path = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads\\";
        ChromeOptions op = new ChromeOptions();
        Map<String, Object> ref = new HashMap<>();
        ref.put("download.default_directory", path);
        op.setExperimentalOption("prefs", ref);
        driver = Driver.getDriver(op);
        driver.get(ConfigReader.getProperty("BaseUrl") + subDomain);
    }

    @When("user clicks on filename {string}")
    public void user_clicks_on_filename(String filename) {

        driver.findElement(By.linkText(filename)).click();
        WaitUntil.seconds(2);
    }

    @Then("verify that file is downloaded")
    public void verify_that_file_is_downloaded() {

        Assert.assertTrue(new File(path + "some-file.txt").exists());

    }
}

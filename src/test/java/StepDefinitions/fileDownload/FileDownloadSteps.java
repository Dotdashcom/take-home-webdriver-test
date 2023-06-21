package StepDefinitions.fileDownload;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FileDownloadSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public FileDownloadSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on file download page")
    public void the_user_clicks_on_file_download_page() {
        pageObject.fileDownloadPage().the_user_clicks_on_file_download_page();
    }
    @Then("the user should see the file download page")
    public void the_user_should_see_the_file_download_page() {
        pageObject.fileDownloadPage().the_user_should_see_the_file_download_page();
    }

    @When("the user clicks on the {string} link on the file download page")
    public void the_user_clicks_on_the_link_on_the_file_download_page(String fileName) {
        pageObject.fileDownloadPage().the_user_clicks_on_the_link_on_the_file_download_page(fileName);
    }

    @Then("the user should see the file is downloaded on the file download page")
    public void the_user_should_see_the_file_is_downloaded_on_the_dynamic_loading_page() {
        pageObject.fileDownloadPage().the_user_should_see_the_file_is_downloaded_on_the_dynamic_loading_page();
    }
}

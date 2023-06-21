package StepDefinitions.fileUpload;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FileUploadSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public FileUploadSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on file upload page")
    public void the_user_clicks_on_file_upload_page() {
        pageObject.fileUploadPage().the_user_clicks_on_file_upload_page();
    }
    @Then("the user should see the file upload page")
    public void the_user_should_see_the_file_upload_page() {
        pageObject.fileUploadPage().the_user_should_see_the_file_upload_page();
    }
    @When("the user clicks upload a test file on the file upload page")
    public void the_user_clicks_upload_a_test_file_on_the_file_upload_page() {
        pageObject.fileUploadPage().the_user_clicks_upload_a_test_file_on_the_file_upload_page();
    }
    @Then("the user should see the file is uploaded on the file upload page")
    public void the_user_should_see_the_file_is_uploaded_on_the_file_upload_page() {
        pageObject.fileUploadPage().the_user_should_see_the_file_is_uploaded_on_the_file_upload_page();
    }
}

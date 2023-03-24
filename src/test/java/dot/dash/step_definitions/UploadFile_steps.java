package dot.dash.step_definitions;

import dot.dash.pages.Upload;
import dot.dash.utilities.WaitUntil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UploadFile_steps {
    Upload up = new Upload();

    @When("user clicks {string} button")
    public void user_clicks_button(String btnName) {
        switch (btnName) {
            case "Choose File":
                up.chooseFileInput.sendKeys("C:\\Users\\yasha\\IdeaProjects\\take-home-webdriver-test\\src\\test\\resources\\upload_file\\some-file.txt");
                break;
            case "Upload":
                up.uploadBtn.click();
                break;
        }
    }

    @Then("user must see {string} message")
    public void user_must_see_message(String mess) {
        WaitUntil.visibilityOf(up.message);
        Assert.assertEquals(up.message.getText(), mess);
    }
}

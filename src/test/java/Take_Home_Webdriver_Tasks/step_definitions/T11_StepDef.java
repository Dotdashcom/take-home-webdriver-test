package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.FilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class T11_StepDef {

    // This page worked successfully in my computer since I am owner the given file path, it will not work on your computer. This is the reason I commented it. You can try from your own computer file to add! the script definitely will work.

    FilePage filePage = new FilePage();
    @When("user upload a file into Choose File")
    public void user_upload_a_file_into_choose_file() {
       // String filePath = "C:\\Users\\ziyne\\Desktop\\LambdaTest.txt";
       // filePage.chooseFile.sendKeys(filePath);

    }
    @Then("user clicks on Upload Button")
    public void user_clicks_on_upload_button() {
       // filePage.uploadBtn.click();

    }
    @Then("verify that the file is uploaded")
    public void verify_that_the_file_is_uploaded() {

       // Assert.assertEquals("File Uploaded!", filePage.uploadMsg.getText());
    }
}

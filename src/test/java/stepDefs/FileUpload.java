package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Driver;

public class FileUpload {

    @Given("I am on the File Upload page")
    public void i_am_on_the_File_Upload_page() {
        Driver.getDriver().get("http://localhost:7080/upload");
    }

    @When("I use Upload Button or Drag and Drop to upload a file")
    public void i_use_Upload_Button_or_Drag_and_Drop_to_upload_a_file() {
Driver.getDriver().findElement(By.className("dz-success-mark dz-clickable")).sendKeys("Users/allashevchenko/Desktop/TheMonarchButterfly.docx");
Driver.getDriver().findElement(By.className("button")).click();
    }

    @Then("I assert that the file is uploaded")
    public void i_assert_that_the_file_is_uploaded() {
        System.out.println("File Uploaded! " + Driver.getDriver().findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());

    }
}

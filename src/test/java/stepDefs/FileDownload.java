package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Driver;

public class FileDownload {
    @Given("I am on the File Download page")
    public void i_am_on_the_File_Download_page() {
        Driver.getDriver().get("http://localhost:7080/download");
        Driver.getDriver().manage().window().maximize();
    }

    @When("I click on the file")
    public void i_click_on_the_file() {
        Driver.getDriver().findElement(By.xpath("//a[text()='some-file.txt']")).click();

    }

    @Then("I assert that the file is downloaded")
    public void i_assert_that_the_file_is_downloaded() {
       // Assert.assertTrue();

    }
}

package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Driver;

public class Iframe {
    String expected="Test switches to Iframe and types some text.Test asserts that the typed text is as expected.";
    @Given("I am on the Iframe page")
    public void i_am_on_the_Iframe_page() {

        Driver.getDriver().get("http://localhost:7080/iframe");
        Driver.getDriver().manage().window().maximize();
    }

    @When("I switch to Iframe and type some text")
    public void i_switch_to_Iframe_and_type_some_text() throws InterruptedException {
          Driver.getDriver().switchTo().frame(0);

          Thread.sleep(2000);
          Driver.getDriver().findElement(By.xpath("// p[text()='Your content goes here.']")).clear();
          Driver.getDriver().findElement(By.xpath("//p")).sendKeys(expected);
    }

    @Then("I verify that the typed text is as expected")
    public void i_verify_that_the_typed_text_is_as_expected() {
      String actual =  Driver.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(expected,actual);
        System.out.println("The actual text is as expected"+ actual);
    }

}

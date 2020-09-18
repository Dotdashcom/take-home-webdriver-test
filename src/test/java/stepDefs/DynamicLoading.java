package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import static org.junit.Assert.assertEquals;

public class DynamicLoading {
    @Given("I am on the Dynamic Loading page")
    public void i_am_on_the_Dynamic_Loading_page() {
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");
        Driver.getDriver().manage().window().maximize();
    }

    @Then("I assert that  {string} text is displayed")
    public void i_assert_that_text_is_displayed(String expected) {
        Driver.getDriver().findElement(By.xpath("//button[text()='Start']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        assertEquals(expected,Driver.getDriver().findElement(By.xpath("//h4[text()='Hello World!']")).getText());

        System.out.println("Hello World is displayed " +Driver.getDriver().findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
    }
}

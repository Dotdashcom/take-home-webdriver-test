package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class FloatingMenu {
    @Given("I am on the Floating Menu page")
    public void i_am_on_the_Floating_Menu_page() {
        Driver.getDriver().get(" http://localhost:7080/floating_menu");
    }

    @When("I scroll the page")
    public void i_scroll_the_page() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
    }

    @Then("I varify that the floating menu is still displayed")
    public void i_varify_that_the_floating_menu_is_still_displayed() {
System.out.println("The Floating menu is displayed "+Driver.getDriver().findElement(By.xpath("//*[@id='menu']")).isDisplayed());
    }

}

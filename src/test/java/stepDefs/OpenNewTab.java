package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Driver;

import java.util.Set;

public class OpenNewTab {
    @Given("I am on the new tab page")
    public void i_am_on_the_new_tab_page() {
        Driver.getDriver().get("http://localhost:7080/windows");
        Driver.getDriver().manage().window().maximize();
    }

    @When("I click Here link")
    public void i_click_Here_link() {
        String parentwidowhandle= Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();


        Set<String> handels=Driver.getDriver().getWindowHandles();
        for(String windowHandle:handels){
            if(!windowHandle.equals(parentwidowhandle)){
            Driver.getDriver().switchTo().window(windowHandle);}
        }
    }

    @Then("I assert that a new tab is opened with text New Window")
    public void i_assert_that_a_new_tab_is_opened_with_text_New_Window() {
        String expected = "New Window";
String title = Driver.getDriver().getTitle();
        Assert.assertEquals(expected, title);
System.out.println("The title of a new opened tab is as expected " + title);
    }

}

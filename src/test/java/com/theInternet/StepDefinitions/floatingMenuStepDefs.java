package com.theInternet.StepDefinitions;

import com.theInternet.Pages.floatingMenuPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

public class floatingMenuStepDefs {
    floatingMenuPage floatingMenuPage = new floatingMenuPage();

    @Given("User on Floating Menu page")
    public void user_on_Floating_Menu_page() {
        System.out.println("Opening the Floating Menu page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "floating_menu");
        Driver.get().manage().window().fullscreen();
    }

    @When("scrolls the page")
    public void scrolls_the_page() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
       // js.executeScript("arguments[0].scrollIntoView(true);", floatingMenuPage.bottom);
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(3000);
    }

    @Then("floating menu is still displayed")
    public void floating_menu_is_still_displayed() {
        assertTrue(floatingMenuPage.home.isDisplayed());
        assertTrue(floatingMenuPage.news.isEnabled());
        assertTrue(floatingMenuPage.contact.isEnabled());
        assertTrue(floatingMenuPage.about.isEnabled());
        System.out.println("Floating Menu is still displayed");
    }
}

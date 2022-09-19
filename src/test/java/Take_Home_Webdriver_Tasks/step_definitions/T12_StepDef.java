package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.FloatingMenuPage;
import Take_Home_Webdriver_Tasks.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class T12_StepDef {

    FloatingMenuPage page = new FloatingMenuPage();

    @When("user scrolls down the page")
    public void user_scrolls_down_the_page() {
        //1st approach:
        // Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(page.endPage).perform();

        //2nd approach:
        BrowserUtils.scrollToElement(page.endPage);

    }
    @Then("verify that the floating menu is still displayed")
    public void verify_that_the_floating_menu_is_still_displayed() {

       for(WebElement eachFloatingMenu : page.floatingMenu){
           Assert.assertTrue(eachFloatingMenu.isDisplayed());
       }
    }
}

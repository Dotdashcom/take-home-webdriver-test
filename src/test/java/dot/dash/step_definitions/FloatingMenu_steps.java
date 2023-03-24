package dot.dash.step_definitions;

import dot.dash.pages.FloatMenu;
import dot.dash.utilities.Driver;
import dot.dash.utilities.WaitUntil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FloatingMenu_steps {
    FloatMenu fl = new FloatMenu();
    @When("verify Floating menu displayed at the top of page")
    public void verify_floating_menu_displayed_at_the_top_of_page() {
        for (WebElement menu : fl.menus()) {
            Assert.assertTrue(menu.isDisplayed());
        }
    }

    @Then("scroll the page down by <{int}> pixels")
    public void scroll_the_page_down_by_pixels(Integer pxl) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "window.scrollBy(0,"+pxl+")";
        js.executeScript(script);
        WaitUntil.visibilityOf(fl.menus().get(1));
    }
}

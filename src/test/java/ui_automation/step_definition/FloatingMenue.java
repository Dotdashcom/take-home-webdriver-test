package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui_automation.pages.FloatingMenuPag;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FloatingMenue {

    WebDriver driver = Driver.getDriver();
    FloatingMenuPag pag = new FloatingMenuPag(driver);

    @Given("User Navigate to floating URL")
    public void user_Navigate_to_floating_URL() {
        String floatingMenu = (ConfigurationReder.getProperties("ui-config.properties", "floatingMenu"));
        driver.get(floatingMenu);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user compare the value of menu")
    public void user_compare_the_value_of_menu(io.cucumber.datatable.DataTable dataTable) {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String expected =null;
        String real = null;
        List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
        int i = 0;

        for (Map<String, String> elemnt : map) {
            expected = elemnt.get("menu");
            real = pag.menus.get(i).getText();
            Assert.assertEquals(expected, real);
            i++;
        }


        Assert.assertEquals(expected, real);


        Driver.closeDriver();
    }

}

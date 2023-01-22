package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.HoverOverPage;
import ui_automation.pages.IFramePage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HoverOver {

    WebDriver driver = Driver.getDriver();
    HoverOverPage page = new HoverOverPage(driver);


    @Given("user navigate  HoverOver URL")
    public void user_navigate_HoverOver_URL() {
        String HoveroverURL = (ConfigurationReder.getProperties("ui-config.properties", "HoveroverURL"));
        driver.get(HoveroverURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Then("user hover over on images to check users")
    public void user_hover_over_on_images_to_check_users(io.cucumber.datatable.DataTable dataTable) {
        int i = 0;
        ;
        String expected = null;

        Actions actions = new Actions(driver);
//        actions.moveToElement(page.img1).perform();


        List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> elemnt : map) {

            expected = elemnt.get("users");
            actions.moveToElement(page.imgs.get(i)).build().perform();

            String realValues = page.users.get(i).getText();
            i++;

            System.out.println("Expected: " + expected);
            System.out.println("Real " + realValues);

        }

        Driver.closeDriver();
    }


}

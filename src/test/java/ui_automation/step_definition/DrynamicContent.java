package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.DynamicContent;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DrynamicContent {

    WebDriver driver = Driver.getDriver();
    DynamicContent dynamicContent = new DynamicContent(driver);

    @Given("user navigate to the Dynamic Content URL")
    public void user_navigate_to_the_Dynamic_Content_URL() {
        String DynamicContectURL = (ConfigurationReder.getProperties("ui-config.properties", "DynamicContect"));
        driver.get(DynamicContectURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user click on the click here link to make changes")
    public void user_click_on_the_click_here_link_to_make_changes() {
      dynamicContent.clickhere.click();

    }

    @Then("user veriffy the changes of photo and text")
    public void user_veriffy_the_changes_of_photo_and_text() {
       String thirdTextBeforeClick = dynamicContent.thirdContext.getText();
//        dynamicContent.clickhere.click();
        driver.navigate().refresh();
        driver.navigate().refresh();
        String thirdTextAfterClick = dynamicContent.thirdContext.getText();
        System.out.println("Context before click: " + thirdTextBeforeClick);
        System.out.println("Context after click: " + thirdTextAfterClick);

        Assert.assertNotEquals(thirdTextBeforeClick, thirdTextAfterClick);


    }

    @Then("user close the browser")
    public void user_close_the_browser() {
     Driver.closeDriver();
    }

}

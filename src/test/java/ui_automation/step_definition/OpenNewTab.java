package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.OpenNewTabPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenNewTab {

    WebDriver driver = Driver.getDriver();
    OpenNewTabPage page = new OpenNewTabPage(driver);


    @Given("user navigate to the targer URl")
    public void user_navigate_to_the_targer_URl() {
        String openNewTab = (ConfigurationReder.getProperties("ui-config.properties", "openNewTab"));
        driver.get(openNewTab);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user click on the click here link to open new Tab")
    public void user_click_on_the_click_here_link_to_open_new_Tab() {
     page.ckickhere.click();

    }



    @Then("user see message {string} and verify the message user navigate to the main UR")
    public void user_see_message_and_verify_the_message_user_navigate_to_the_main_UR(String message) {
        Set<String> guiIDes = driver.getWindowHandles();
        Iterator<String> i = guiIDes.iterator();
        String manID = i.next();
        String secondTabID = i.next();

        driver.switchTo().window(secondTabID);
        String realMsg = driver.getTitle();
        Assert.assertEquals(message, realMsg);



        driver.switchTo().window(manID);
        String titleMain = driver.getTitle();
        String expMsg = "The Internet";
        Assert.assertEquals(expMsg, titleMain);


        Driver.closeDriver();

    }




}

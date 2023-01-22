package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.DynamicControlsPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicControls {

    WebDriver driver = Driver.getDriver();
    DynamicControlsPage page = new DynamicControlsPage(driver);


    @Given("User Navigate to dynamic Controls URL")
    public void user_Navigate_to_dynamic_Controls_URL() {
        String dynamicControURL = (ConfigurationReder.getProperties("ui-config.properties", "dynamicControlURL"));
        driver.get(dynamicControURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user click on the Remove button to remove checkBox from page and verify the message {string}")
    public void user_click_on_the_Remove_button_to_remove_checkBox_from_page_and_verify_the_message(String expMessage) {
       page.removeAddBtn.click();
       String actualMessage = page.actualMessage.getText();
       WebDriverWait wait  = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        System.out.println(actualMessage);
        System.out.println(expMessage);
        Assert.assertEquals(expMessage,actualMessage);
    }



    @Then("user click on the add butten and verify the message {string}")
    public void user_click_on_the_add_butten_and_verify_the_message(String expMessage) {
        page.removeAddBtn.click();
        String actualMessage = page.actualMessage.getText();
        WebDriverWait wait  = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        System.out.println(actualMessage);
        System.out.println(expMessage);
        Assert.assertEquals(expMessage,actualMessage);
    }




    @Given("Uer should be able to Navigate to the dynamic Control URl")
    public void uer_should_be_able_to_Navigate_to_the_dynamic_Control_URl() {
        String dynamicControURL = (ConfigurationReder.getProperties("ui-config.properties", "dynamicControlURL"));
        driver.get(dynamicControURL);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Then("user should be able to verify enable or disable btn with the help of message {string}")
    public void user_should_be_able_to_verify_enable_or_disable_btn_with_the_help_of_message(String expectedMsg) {
        String btnlabel = page.enableBTN.getText();
        String btnLabelAfterClick = "Disable";
        Assert.assertEquals(btnLabelAfterClick, btnlabel);
    }

    @Then("User should be able to click on the enable button to enable the input box and verify message {string}")
    public void user_should_be_able_to_click_on_the_enable_button_to_enable_the_input_box_and_verify_message(String enableMsg ) {
        page.enableBTN.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='input-example']/p[@id='message']")));
        String realMsg = page.enableDisableMsg.getText();
//        System.out.println("it should show enable "+ realMsg);
         Assert.assertEquals(enableMsg, realMsg);
    }

    @Then("user should be able to click again to disable the butten and verify messsage  {string}")
    public void user_should_be_able_to_click_again_to_disable_the_butten_and_verify_messsage(String disableMsg) {
        page.enableBTN.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='input-example']/p[@id='message']")));
        String realMsg = page.enableDisableMsg.getText();
//        System.out.println("Its should show disable : " + realMsg);
        Assert.assertEquals(disableMsg, realMsg);
    }

    @Then("user clsoe driver")
    public void user_clsoe_driver() {
        Driver.closeDriver();
    }


}

package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.CheckBoxesPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

public class CheckBoxes {

    WebDriver driver = Driver.getDriver();
    Hooks hooks = new Hooks();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);

    @Given("User navigate to checkboxes URL")
    public void user_navigate_to_checkboxes_URL() {
     String checkBoxesURL = (ConfigurationReder.getProperties("ui-config.properties", "CheckBox"));
     driver.get(checkBoxesURL);
    }


    @Then("user select checkbox numberOne")
    public void user_select_checkbox_numberOne() {
        checkBoxesPage.checkBox1.click();
        Assert.assertTrue(checkBoxesPage.checkBox1.isSelected());
//        System.out.println("checkBox 1 : True"+checkBoxesPage.checkBox1.isSelected());

    }

    @Then("user uncheck checkbox numberTwo")
    public void user_uncheck_checkbox_numberTwo() {
       checkBoxesPage.checkBox2.click();
       Assert.assertFalse(checkBoxesPage.checkBox2.isSelected());
//        System.out.println("Checkbox 2: false "+ checkBoxesPage.checkBox2.isSelected());

    }


    @Then("close URL")
    public void close_URL() {
       Driver.closeDriver();
    }





}

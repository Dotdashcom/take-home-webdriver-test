package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui_automation.pages.DropDownPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

    WebDriver driver = Driver.getDriver();
    DropDownPage dropDownPage = new DropDownPage(driver);


    @Given("user should be able to Navigate to DropDown URL")
    public void user_should_be_able_to_Navigate_to_DropDown_URL() {
        String dropDown = (ConfigurationReder.getProperties("ui-config.properties", "DropDownURL"));
        driver.get(dropDown);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user click on the dropDown to choose second option")
    public void user_click_on_the_dropDown_to_choose_second_option() throws InterruptedException {
        Select select = new Select(dropDownPage.dropArrow);

        String[] expected = {"Please select an option", "Option 1", "Option 2"};
        List<WebElement> options = select.getOptions();
         // assert values
        for(int i=0; i<options.size(); i++){
         String actualVal = options.get(i).getText();
         String expectedVal = expected[i];
         Assert.assertEquals(expectedVal, actualVal);
        }

        // select Option 2
        select.selectByVisibleText("Option 2");
        Assert.assertTrue(dropDownPage.option2.isSelected());
//        Thread.sleep(2000);
       ///select Option 1
        select.selectByVisibleText("Option 1");
        Assert.assertTrue(dropDownPage.option1.isSelected());
    }

    @Then("driver should be clsoe")
    public void driver_should_be_clsoe() {
      Driver.closeDriver();
    }

}

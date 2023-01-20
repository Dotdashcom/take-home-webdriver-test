package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicControlsPage {
    public WebDriver driver;
    public Helpers helpers;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By original_checkbox = By.xpath("//div[@id='checkbox']/input");
    public By created_checkbox = By.id("checkbox");
    public By button_remove = By.xpath("//button[text()='Remove']");
    public By button_add = By.xpath("//button[text()='Add']");

    public By message_ra = By.id("message");


    //ENABLE/DISABLE
    public By text_input = By.xpath("//form[@id='input-example']/input");
    public By button_enable = By.xpath("//button[text()='Enable']");
    public By button_disable = By.xpath("//button[text()='Disable']");
    public By message_ed = By.id("message");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToDynamicControls() {
        driver.navigate().to(driver.getCurrentUrl() + "dynamic_controls");
    }

    public void RemoveCheckbox() {

        helpers.Click(button_remove);
    }

    public void AssertRemoval() {
        helpers.WaitElementToBePresent(message_ra);
        boolean exist = driver.findElements(created_checkbox).size() == 0;
        Assert.assertTrue(exist, "Checkbox wasn't removed");
        Assert.assertEquals(helpers.getText(message_ra), "It's gone!", "Message is not displayed or wrong.");
    }

    public void AddCheckbox() {

        helpers.Click(button_add);
    }

    public void AssertAdding() {
        helpers.WaitElementToBePresent(message_ra);
        boolean exist = driver.findElements(created_checkbox).size() == 0;
        Assert.assertFalse(exist, "Checkbox wasn't added");
        Assert.assertEquals(helpers.getText(message_ra), "It's back!", "Message is not displayed or wrong.");

    }

    public void EnableInput() {

        helpers.Click(button_enable);
    }

    public void AssertEnabling() {
        helpers.WaitElementToBePresent(message_ed);
        boolean exist = driver.findElement(text_input).isEnabled();
        Assert.assertTrue(exist, "Input is still Disabled");
        Assert.assertEquals(helpers.getText(message_ed), "It's enabled!", "Message is not displayed or wrong.");
    }

    public void DisableInput() {

        helpers.Click(button_disable);
    }

    public void AssertDisabling() {
        helpers.WaitElementToBePresent(message_ed);
        boolean exist = driver.findElement(text_input).isEnabled();
        Assert.assertFalse(exist, "Input is still Enabled");
        Assert.assertEquals(helpers.getText(message_ed), "It's disabled!", "Message is not displayed or wrong.");

    }


}

package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DynamicControls {
    DynamicControlsPage dynamicControls = new DynamicControlsPage();

    @Test()
    public void test01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl") + "dynamic_controls"); //Go to "http://localhost:7080/dynamic_controls" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        Assert.assertTrue(dynamicControls.checkBox.isDisplayed());
        System.out.println(("Checkbox is displayed"));

        dynamicControls.removeButton.click();
        System.out.println(("Explicit wait ..."));
        ReusableMethods.waitForVisibility(dynamicControls.goneMessage, 5);
        System.out.println(("Info message is displayed  " + dynamicControls.checkboxGone.getText()));

        Assert.assertTrue(dynamicControls.checkboxGone.isDisplayed());
        System.out.println(("Gone message is displayed " + dynamicControls.goneMessage.getText()));
        dynamicControls.addButton.click();
        ReusableMethods.waitForVisibility(dynamicControls.backMessage, 5);
        Assert.assertTrue(dynamicControls.checkBox.isDisplayed());

        System.out.println(("Enable button has been clicked"));
        dynamicControls.enableDisableButton.click();
        System.out.println(("Explicit Wait ..."));
        ReusableMethods.waitForVisibility(dynamicControls.enableMessage, 15);
        System.out.println(("Enable is displayed " + dynamicControls.enableMessage.getText()));
        Assert.assertEquals(dynamicControls.enableMessage.getText(), "It's enabled!");

        System.out.println(("Disable button has been clicked"));
        dynamicControls.enableDisableButton.click();
        System.out.println(("Explicit Wait ..."));
        ReusableMethods.waitForVisibility(dynamicControls.disableMessage, 15);
        System.out.println(("Disable is displayed " + dynamicControls.disableMessage.getText()));

        Assert.assertEquals(dynamicControls.disableMessage.getText(), "It's disabled!");

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

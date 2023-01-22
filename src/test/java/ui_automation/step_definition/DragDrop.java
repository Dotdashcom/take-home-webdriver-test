package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.DragDropPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DragDrop {

    WebDriver driver = Driver.getDriver();

    DragDropPage dragDropPage = new DragDropPage(driver);

    @Given("User navigate to the Drag and Drop URL")
    public void user_navigate_to_the_Drag_and_Drop_URL() throws InterruptedException {
        String drapDropURL = (ConfigurationReder.getProperties("ui-config.properties", "DragAndDropURL"));
        driver.get(drapDropURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("User drag elemnt A to the place of elemnt B")
    public void user_drag_elemnt_A_to_the_place_of_elemnt_B() throws InterruptedException {

       Actions actions = new Actions(driver);
//       actions.dragAndDrop(dragDropPage.elemntA, dragDropPage.elemntB).release().build().perform();
       actions.clickAndHold(dragDropPage.elemntA).moveToElement(dragDropPage.elemntB).release().click().build().perform();
       Thread.sleep(2000);

    }

    @Then("user verified the changes of Drag and Drop")
    public void user_verified_the_changes_of_Drag_and_Drop() {
       String headerA = dragDropPage.headerA.getText().trim();
       String headerB = dragDropPage.headerB.getText().trim();
       Assert.assertEquals("A", headerB);
       Assert.assertEquals("B", headerA);
    }

    @Then("user close the URL")
    public void user_close_the_URL() {

        Driver.closeDriver();
    }

}

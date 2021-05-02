package com.trudova.getInProj.step_definitions;
import com.trudova.getInProj.pages.ContextMenuPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class US3_step_definition {
    private ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Given("click Context Menu link")
    public void click_context_menu_link() {
        contextMenuPage.contextMenu.click();
    }

    @Given("perform context click")
    public void perform_context_click() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.hotspot).perform();

    }


    @Then("switch to alert and accept it")
    public void switch_to_alert_and_accept_it() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("verify page is reachable")
    public void verify_page_is_reachable() {
        Assert.assertTrue(contextMenuPage.hotspot.isEnabled());
    }
}

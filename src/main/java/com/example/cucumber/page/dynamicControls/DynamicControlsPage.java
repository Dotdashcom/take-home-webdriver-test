package com.example.cucumber.page.dynamicControls;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.constants.Page.DYNAMIC_CONTROLS_PAGE;
import static com.example.constants.PageLinkText.DYNAMIC_CONTROLS;
import static org.junit.Assert.*;

public class DynamicControlsPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();

    private By dynamic_controls_page_link = By.linkText(DYNAMIC_CONTROLS);
    private By successMessage_id = By.id("message");
    private By checkbox_id = By.id("checkbox");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void the_user_click_on_dynamic_control_page() {
        clckOnWebElement(dynamic_controls_page_link);
    }

    public void the_use_should_see_the_dynamic_control_page() {
        assertEquals("Checkbox Page URL doesn't Match: ", DYNAMIC_CONTROLS_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_to_remove_the_checkbox_on_the_dynamic_control_page(String removeButton) {
        By removeButtonXpath = By.xpath("//button[contains(text(),'" + removeButton + "')]");
        clckOnWebElement(removeButtonXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
        assertEquals("Checkbox remove message not correct: ", "It's gone!",getWebElementText(successMessage_id));
    }

    public void the_user_should_see_the_checkbox_is_removed_on_the_dynamic_control_page() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        boolean elementNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox_id));
        assertTrue("Checkbox not removed:", elementNotPresent);
    }

    public void the_user_clicks_on_the_to_add_the_checkbox_on_the_dynamic_control_page(String addButton) {
        By addButtonXpath = By.xpath("//button[contains(text(),'" + addButton + "')]");
        clckOnWebElement(addButtonXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
        assertEquals("Checkbox add message not correct: ", "It's back!",getWebElementText(successMessage_id));
    }

    public void the_user_should_see_the_checkbox_is_added_on_the_dynamic_control_page() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox_id));
        assertTrue("Checkbox is added", checkbox.isDisplayed());
    }

    public void the_user_clicks_on_the_button_to_enable_the_text_box_on_the_dynamic_control_page(String enableButton) {
        By enableButtonXpath = By.xpath("//button[contains(text(),'" + enableButton + "')]");
        clckOnWebElement(enableButtonXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement textbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));
        assertEquals("Checkbox remove message not correct: ", "It's enabled!",getWebElementText(successMessage_id));
    }

    public void the_user_should_see_the_text_box_is_enabled_on_the_dynamic_control_page() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement textbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));
        assertTrue("Textbox is not enabled", textbox.isEnabled());
    }

    public void the_user_clicks_on_the_button_to_disable_the_text_box_on_the_dynamic_control_page(String disableButton) {
        By disableButtonXpath = By.xpath("//button[contains(text(),'" + disableButton + "')]");
        clckOnWebElement(disableButtonXpath);
        WebElement textbox = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !textbox.isEnabled();
            }
        });
        assertEquals("Textbox enable message not correct: ", "It's disabled!",getWebElementText(successMessage_id));
    }

    public void the_user_should_see_the_text_box_is_disabled_on_the_dynamic_control_page() {
        WebElement textbox = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        assertFalse("Textbox is enabled", textbox.isEnabled());
    }
}

package com.example.cucumber.page.checkbox;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.example.constants.Page.CHECK_BOX_PAGE;
import static com.example.constants.PageLinkText.CHECKBOXES;
import static org.junit.Assert.*;

public class CheckBoxPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    private By checkbox_link = By.linkText(CHECKBOXES);
    private By checkbox_xpath = By.xpath("//input[@type='checkbox']");
    public CheckBoxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void the_user_click_on_checkbox_page() {
        clckOnWebElement(checkbox_link);
    }
    public void the_use_should_see_the_checkbox_page() {
        assertEquals("Checkbox Page URL doesn't Match: ", CHECK_BOX_PAGE, driver.getCurrentUrl());
    }
    public void the_user_should_check_all_the_checkboxes_on_the_checkbox_page() {
        List<WebElement> checkboxes = driver.findElements(checkbox_xpath);
        checkboxes.forEach((box) -> {
            if (box.getAttribute("checked") == null){
                box.click();
            }
        } );
    }
    public void the_user_should_see_all_the_checkboxes_are_checked_on_the_checkbox_page() {
        List<WebElement> checkboxes = driver.findElements(checkbox_xpath);
        boolean allChecked = checkboxes.stream()
                .allMatch(WebElement::isSelected);
        assertTrue("All checkboxes should be checked", allChecked);
    }
    public void the_user_should_uncheck_all_the_checkboxes_on_the_checkbox_page() {
        List<WebElement> checkboxes = driver.findElements(checkbox_xpath);
        checkboxes.forEach((box) -> {
            if (box.getAttribute("checked") != null){
                box.click();
            }
        } );
    }
    public void the_user_should_see_all_the_checkboxes_are_unchecked_on_the_checkbox_page() {
        List<WebElement> checkboxes = driver.findElements(checkbox_xpath);
        boolean allChecked = checkboxes.stream()
                .allMatch(WebElement::isSelected);
        assertFalse("All checkboxes should be unchecked", allChecked);
    }
}

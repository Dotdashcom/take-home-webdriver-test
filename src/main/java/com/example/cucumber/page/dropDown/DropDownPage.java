package com.example.cucumber.page.dropDown;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.example.constants.Page.DROP_DOWN_PAGE;
import static com.example.constants.PageLinkText.DROPDOWN;
import static org.junit.Assert.assertEquals;

public class DropDownPage extends WebDriverJavaUtil {
    private WebDriver driver;
    private ReadProperties readProperties = new ReadProperties();
    public DropDownPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By drop_down_page_link = By.linkText(DROPDOWN);
    private By drop_down_id = By.id("dropdown");
    private Select dropDownSelect;

    public void the_user_click_on_dropdown_page() {
        clckOnWebElement(drop_down_page_link);
    }

    public void the_use_should_see_the_dropdown_page() {
        assertEquals("DropDown Page URL doesn't Match: ", DROP_DOWN_PAGE, driver.getCurrentUrl());
    }

    public void the_user_select_dropdown_on_the_dropdown_page(String option) {
        WebElement dropdown = driver.findElement(drop_down_id);
        dropDownSelect = new Select(dropdown);
        dropDownSelect.selectByVisibleText(option);
    }

    public void the_user_should_see_dropdown_is_selected_on_the_dropdown_page(String option) {
        WebElement selectedOption = dropDownSelect.getFirstSelectedOption();
        assertEquals("Item not selected correctly from the dropdown: ",option, selectedOption.getText());
    }
}

package com.example.cucumber.page.contextMenu;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.example.constants.Page.CONTEXT_MENU_PAGE;
import static com.example.constants.PageLinkText.CONTEXT_MENU;
import static org.junit.Assert.assertEquals;

public class ContextMenuPage extends WebDriverJavaUtil {

    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();

    private By context_menu_link = By.linkText(CONTEXT_MENU);

    public ContextMenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void the_user_clicks_on_context_menu_page() {
        clckOnWebElement(context_menu_link);
    }

    public void the_user_should_see_the_context_menu_page() {
        assertEquals("Context Menu Page URL doesn't Match: ", CONTEXT_MENU_PAGE, driver.getCurrentUrl());
    }

    public void the_user_right_click_in_the_dotted_box_in_the_context_menu_page() {
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        waitForMilliSeconds(1000);
    }

    public void the_user_should_see_the_context_menu_in_the_context_menu_page() {
        Alert alert = driver.switchTo().alert();
        assertEquals("Invalid alert message: ", "You selected a context menu", alert.getText());
        alert.accept();
    }
}

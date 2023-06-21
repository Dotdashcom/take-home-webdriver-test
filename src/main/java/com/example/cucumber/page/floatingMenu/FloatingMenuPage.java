package com.example.cucumber.page.floatingMenu;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.constants.Page.FLOATING_MENU_PAGE;
import static com.example.constants.PageLinkText.FLOATING_MENU;
import static org.junit.Assert.*;

public class FloatingMenuPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    private WebElement homeMenuXpath;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By floating_menu_page_link = By.linkText(FLOATING_MENU);

    public void the_user_clicks_on_floating_menu_page() {
        clckOnWebElement(floating_menu_page_link);
    }
    public void the_user_should_see_the_floating_menu_page() {
        assertEquals("Floating Menu Page URL doesn't Match: ", FLOATING_MENU_PAGE, driver.getCurrentUrl());
    }

    public void the_user_scrolls_on_the_floating_menu_page() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForMilliSeconds(3000);
    }

    public void the_user_should_see_the_floating_menu_is_still_displayed_on_the_floating_menu_page() {
        homeMenuXpath = driver.findElement(By.xpath("//a[@href='#home']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement floatingMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#home']")));
        boolean isMenuVisible = floatingMenu.isDisplayed();
        assertTrue("Floating menu is not displayed within the screen", isMenuVisible);
    }
}

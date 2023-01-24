package com.dotdash.pageobject;

import com.dotdash.helper.ElementDisplayed;
import com.dotdash.helper.PageController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FloatingMenuPage extends BasePageObject{

    private By menu = By.id("menu");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        open_page("floating_menu");
    }

    public FloatingMenuPage scroll_to_bottom() {
        PageController.scroll_to_bottom(driver);
        return this;
    }

    public void verify_menu_is_still_displayed_on_top() {
        Assert.assertTrue(ElementDisplayed.is_in_view_port(driver, driver.findElement(menu)));
    }
}

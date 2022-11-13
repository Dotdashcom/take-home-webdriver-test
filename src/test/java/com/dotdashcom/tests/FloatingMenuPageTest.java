package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.FloatingMenuPageModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class FloatingMenuPageTest extends MainTest {

    FloatingMenuPageModel page;
    final List<String> EXPECTED_MENU_ITEM_NAMES = Arrays.asList("Home", "News", "Contact", "About");

    private void init() {
        page = new FloatingMenuPageModel(driver);
        driver.get(BASE_URL + FloatingMenuPageModel.PAGE_URL);
    }

    @Test
    void WHEN_scroll_page_THEN_menu_still_visible() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(FloatingMenuPageModel.PAGE_URL));

        List<WebElement> menuItems = page.findMenuItems();
        // We expect 4 elements of the menu before scrolling
        Assert.assertEquals(menuItems.size(), EXPECTED_MENU_ITEM_NAMES.size());

        page.scrollBrowserWindow();

        // We still expect 4 elements of the menu after scrolling
        Assert.assertEquals(menuItems.size(), EXPECTED_MENU_ITEM_NAMES.size());

        // End check menu item names
        ofNullable(menuItems).orElse(emptyList()).stream()
                .forEach(i -> Assert.assertTrue(EXPECTED_MENU_ITEM_NAMES.contains(i.getText())));
    }
}

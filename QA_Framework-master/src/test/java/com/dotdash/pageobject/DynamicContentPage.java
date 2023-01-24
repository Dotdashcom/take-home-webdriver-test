package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DynamicContentPage extends BasePageObject {
    private final By dynamic_contents = By.xpath("//div[@class='large-10 columns']");

    private final int CONTENT_INDEX_01 = 0;
    private final int CONTENT_INDEX_02 = 1;
    private final int CONTENT_INDEX_03 = 2;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        open_page("dynamic_content");
    }

    public void verify_content_change_after_refresh(int time_to_refresh) {
        for (int refresh_time = 0; refresh_time < time_to_refresh; refresh_time++) {
            final String first_content_before_change = get_content_base_on_index(CONTENT_INDEX_01);
            final String second_content_before_change = get_content_base_on_index(CONTENT_INDEX_02);
            final String third_content_before_change = get_content_base_on_index(CONTENT_INDEX_03);

            driver.navigate().refresh();
            final String first_content_after_change = get_content_base_on_index(CONTENT_INDEX_01);
            final String second_content_after_change = get_content_base_on_index(CONTENT_INDEX_02);
            final String third_content_after_change = get_content_base_on_index(CONTENT_INDEX_03);

            Assert.assertNotEquals(first_content_before_change, first_content_after_change, "[ERR] Content 01 was NOT changed!");
            Assert.assertNotEquals(second_content_before_change, second_content_after_change, "[ERR] Content 02 was NOT changed!");
            Assert.assertNotEquals(third_content_before_change, third_content_after_change, "[ERR] Content 03 was NOT changed!");
        }
    }

    private String get_content_base_on_index(int index) {
        List<WebElement> contents = driver.findElements(dynamic_contents);
        return contents.get(index).getText();
    }
}

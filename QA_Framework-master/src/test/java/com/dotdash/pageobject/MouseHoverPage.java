package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class MouseHoverPage extends BasePageObject {

    private By user_avatars = By.cssSelector(".figure");
    private By user_profile_names = By.cssSelector(".figcaption h5");
    private By user_profile_links = By.cssSelector(".figcaption a");
    private List<WebElement> user_avatar_elems = null;
    private List<WebElement> user_profile_name_elems = null;
    private List<WebElement> user_profile_link_elems = null;

    private final String USER_01_NAME = "name: user1";
    private final String USER_02_NAME = "name: user2";
    private final String USER_03_NAME = "name: user3";

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        open_page("hovers");
    }

    public MouseHoverPage mouse_over_user(int user_num) {
        if (user_avatar_elems == null) user_avatar_elems = driver.findElements(user_avatars);
        Actions action = new Actions(driver);
        action.moveToElement(user_avatar_elems.get(user_num - 1)).perform();
        return this;
    }

    public void verify_general_info_for_user(int user_num) {
        if (user_profile_name_elems == null) user_profile_name_elems = driver.findElements(user_profile_names);
        if (user_profile_link_elems == null) user_profile_link_elems = driver.findElements(user_profile_links);
        boolean is_username_displayed = user_profile_name_elems.get(user_num - 1).isDisplayed();
        String actual_user_name_displayed = user_profile_name_elems.get(user_num - 1).getText();

        Assert.assertTrue(is_username_displayed, "[ERR] User info is NOT displayed after mouse-over");
        switch (user_num) {
            case 1:
                Assert.assertEquals(actual_user_name_displayed, USER_01_NAME, "[ERR] username is wrong!");
                break;
            case 2:
                Assert.assertEquals(actual_user_name_displayed, USER_02_NAME, "[ERR] username is wrong!");
                break;
            case 3:
                Assert.assertEquals(actual_user_name_displayed, USER_03_NAME, "[ERR] username is wrong!");
                break;
        }

    }

    public MouseHoverPage click_on_profile_link_user(int user_num) {
        return this;
    }

    public void verify_details_info_for_user(int user_num) {
        //TODO: this will verify user details after click to open user profile page
    }

}

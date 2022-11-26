package com.framework.testcases;

import com.framework.pages.HoversPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoversPageTest extends TestBase {
    HoversPage hoversPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the hovers page")
    public void user_is_on_hovers_page() {
        hoversPage = new HoversPage(driver);
        hoversPage.navigate();
        String actualURL = hoversPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/hovers";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can hover over all images")
    public void user_can_hover_all_images() {
        hoversPage = new HoversPage(driver);
        hoversPage.navigate();
        List<String> actualList = hoversPage.hoverOnAllImages().getAllHoveredUsersList();
        List<String> expectedList = new ArrayList<>(Arrays.asList("name: user1", "name: user2", "name: user3"));
        Boolean areListsEqual = actualList.equals(expectedList);
        Assert.assertTrue(areListsEqual);
    }
	
    @AfterTest
    public void teardown() {
        super.cleanup();
    }

}

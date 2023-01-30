package com.ddm.testcases;

import com.ddm.pageobjects.MouseHoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MouseHoverTests extends BaseTestClass {

    protected MouseHoversPage mouseHoversPage;

    @BeforeMethod
    public void setUpMethodMouseHover() {
        mouseHoversPage = landingPage.goTo("/hovers", MouseHoversPage.class);
    }

    @Test
    public void mouseHoversPageTest() {
        SoftAssert sf = new SoftAssert();

        mouseHoversPage.hoverOnProfile(0);
        sf.assertEquals(mouseHoversPage.getProfileName(0), "name: user1", "Profile name is NOT matching.");
        sf.assertTrue(mouseHoversPage.getProfileLink(0).contains("/users/1"), "Profile link is NOT matching.");

        mouseHoversPage.hoverOnProfile(1);
        sf.assertEquals(mouseHoversPage.getProfileName(1), "name: user2", "Profile name is NOT matching.");
        sf.assertTrue(mouseHoversPage.getProfileLink(1).contains("/users/2"), "Profile link is NOT matching.");;

        mouseHoversPage.hoverOnProfile(2);
        sf.assertEquals(mouseHoversPage.getProfileName(2), "name: user3", "Profile name is NOT matching.");
        sf.assertTrue(mouseHoversPage.getProfileLink(2).contains("/users/3"), "Profile link is NOT matching.");

        sf.assertAll();
    }
}

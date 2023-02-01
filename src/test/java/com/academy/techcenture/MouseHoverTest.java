package com.academy.techcenture;

import com.academy.techcenture.pages.MouseHoverPage;
import org.testng.annotations.Test;

public class MouseHoverTest extends BaseClassTest {

    @Test
    public void mouseHoverTest() {
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver, softAssert);
        mouseHoverPage.navigateTo("/hovers");
        mouseHoverPage.verifyMouseHover();
    }
}

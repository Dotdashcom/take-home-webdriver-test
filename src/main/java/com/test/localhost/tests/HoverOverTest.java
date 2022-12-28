package com.test.localhost.tests;

import com.test.localhost.pages.MouseHoverPage;
import org.testng.annotations.Test;

public class HoverOverTest extends TestBase {

    @Test
    public void hoverOver() throws InterruptedException {
        MouseHoverPage mouseHoverPage=new MouseHoverPage(driver);
        mouseHoverPage.clickHoverButton();
        mouseHoverPage.hoverOverElements(driver);
    }


}

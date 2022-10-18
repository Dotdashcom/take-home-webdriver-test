package com.dotdash.testcases;

import com.dotdash.pageObject.MouseHoverPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class MouseHover extends Setup{
    MouseHoverPage mouseHoverPage;

    public MouseHover(){
        this.mouseHoverPage= MyTestClasses.getObject(MouseHoverPage.class);
    }

    @Test(testName = "validate text after mouse hover")
    public void validateMouseHoverText(){
        navigateTo("hovers");
        mouseHoverPage.hoverMouseOnFigure("1");
        mouseHoverPage.assertDataAfterHover("1");
    }
}

package com.dotdash.testcases;

import com.dotdash.pageObject.FloatingMenuPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class FloatingMenu extends Setup {
    FloatingMenuPage floatingMenuPage;

    public FloatingMenu(){
        this.floatingMenuPage = MyTestClasses.getObject(FloatingMenuPage.class);
    }

    @Test(testName = "validate menu is floating")
    public void validateMenuFloats(){
        navigateTo("floating_menu");
        floatingMenuPage.moveToText();
        floatingMenuPage.assertMenuDisplayedAfterScroll();
    }
}

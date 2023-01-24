package com.dotdash.test.single;

import com.dotdash.pageobject.DragandDrop;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DnD extends BaseTest {

    private DragandDrop dnd_page = null;

    @BeforeMethod
    void init() {
        if (dnd_page == null) dnd_page = new DragandDrop(driver);
    }

    @Test
    void able_to_dnd_left_to_right() throws Exception {
        dnd_page.dnd_left_to_right().verify_text_after_dnd();
    }

    @Test
    void able_to_dnd_right_to_left() throws Exception {
        dnd_page.dnd_right_to_left().verify_text_after_dnd();
    }

}

package com.academy.techcenture;

import com.academy.techcenture.pages.FloatingMenuPage;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseClassTest {

    @Test
    public void floatingMenuTest(){
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver, softAssert);
        floatingMenuPage.navigateTo("/floating_menu");
        floatingMenuPage.verifyFloatingMenu();
    }

}

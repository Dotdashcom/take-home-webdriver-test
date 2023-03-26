package com.test.tests;

import org.junit.jupiter.api.Test;

import com.test.pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownTest extends TestBase {

    @Test
    public void testDropdown() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectOption1();
        assertTrue(dropdownPage.isOption1Selected());

        dropdownPage.selectOption2();
        assertTrue(dropdownPage.isOption2Selected());
    }

}

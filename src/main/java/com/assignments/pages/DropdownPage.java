package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class DropdownPage extends BasePage {
    private final By dropdown = By.id("dropdown");

    public DropdownPage clickOnDropdown(String dropdownOption) {
        click(dropdown, CLICKABLE, "Drop Down");
        select(dropdown, CLICKABLE, dropdownOption);
        return this;
    }

    public boolean getSelectedOption(String option) {
        return getFirstSelected(dropdown, VISIBLE).contains(option);
    }
}

package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;

@Url("/dropdown")
public class Dropdown extends WebPage {

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBy(tagName = "option")
    private List<WebElement> dropdownOptions;

    public Dropdown selectOption(String option) {
        select(dropdown, option);
        return this;
    }

    public boolean isOptionSelected(String option) {
        for (WebElement dropdownOption : dropdownOptions) {
            if (getText(dropdownOption).equals(option)) {
                return dropdownOption.getAttribute("selected") != null;
            }
        }
        return false;
    }
}

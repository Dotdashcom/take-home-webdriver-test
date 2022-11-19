package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;

@Url("/checkboxes")
public class Checkbox extends WebPage {

    @FindBy(tagName = "input")
    private List<WebElement> checkboxes;

    public Checkbox checkAll() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.getAttribute("checked") == null) {
                click(checkbox);
            }
        });
        return this;
    }

    public Checkbox uncheckAll() {
        checkboxes.forEach(checkbox -> {
            if (checkbox.getAttribute("checked") != null) {
                click(checkbox);
            }
        });
        return this;
    }

    public boolean allChecked() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getAttribute("checked") == null) {
                return false;
            }
        }
        return true;
    }

    public boolean allUnchecked() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getAttribute("checked") != null) {
                return false;
            }
        }
        return true;
    }

}

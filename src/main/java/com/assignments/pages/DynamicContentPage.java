package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class DynamicContentPage extends BasePage {
    private final By clickHere = By.xpath("//a[text()='click here']");

    public DynamicContentPage clickOnClickHere() {
        click(clickHere, CLICKABLE, "Click Here Button");
        return this;
    }
}

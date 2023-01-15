package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.enums.WaitStrategy.CLICKABLE;

public final class MultipleWindowPage extends BasePage {

    private final By clickHereButton = By.cssSelector("a[href='/windows/new']");

    public MultipleWindowPage clickOnClickHere() {
        click(clickHereButton, CLICKABLE, "Click Here");
        return this;
    }
}

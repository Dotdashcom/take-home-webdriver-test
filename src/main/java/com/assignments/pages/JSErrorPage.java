package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class JSErrorPage extends BasePage {

    public String getErrorText() {
        return getJSLog();
    }
}

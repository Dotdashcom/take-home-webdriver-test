package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;

public final class ContextPage extends BasePage {
    private final By contextMenuBox = By.id("hot-spot");

    public ContextPage clickContextMenu() {
        contextClick(contextMenuBox, CLICKABLE, "Context Menu Box");
        return this;
    }

    public String testContextMenu() {
        return getAlertMessageAndClickOk();
    }
}

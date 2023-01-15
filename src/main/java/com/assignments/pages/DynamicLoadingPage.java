package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class DynamicLoadingPage extends BasePage {

    private String RUB = "Hello World!";
    private final By hiddenElements = By.xpath("//a[text()='Example 1: Element on page that is hidden']");

    private final By startButton = By.xpath("//button[text()='Start']");

    private final By helloWorldText = By.xpath("//h4[text()='"+RUB+"']");

    public DynamicLoadingPage clickOnHiddenElements() {
        click(hiddenElements, CLICKABLE, "Hidden Elements");
        return this;
    }

    public DynamicLoadingPage clickOnStartButton() {
        click(startButton, CLICKABLE, "Start Button");
        return this;
    }

    public boolean isHelloWorldTextVisible() {
        isDisplayed(helloWorldText, VISIBLE, "Hello World!");
        return true;
    }
}

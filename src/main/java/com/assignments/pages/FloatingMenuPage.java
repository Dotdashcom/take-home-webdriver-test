package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class FloatingMenuPage extends BasePage {

    private final By homeButton = By.xpath("//a[text()='Home']");

    private final By newsButton = By.xpath("//a[text()='News']");

    private final By contactButton = By.xpath("//a[text()='Contact']");

    private final By aboutButton = By.xpath("//a[text()='About']");

    public boolean isMenuVisible() {
        if (isDisplayed(homeButton, VISIBLE, "") && isDisplayed(newsButton, VISIBLE, "")
                && isDisplayed(contactButton, VISIBLE, "")
                && isDisplayed(aboutButton, VISIBLE, "")) {
            return true;
        } else {
            return false;
        }
    }

    public void scrollTillEnd() {
        scrollToEndOfPage();
    }
}

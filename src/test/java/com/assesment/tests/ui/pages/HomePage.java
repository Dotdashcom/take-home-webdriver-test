package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public enum Using {
        LOGIN_PAGE(By.cssSelector("a[href='/login']")),
        CHECK_BOXES_PAGE(By.cssSelector("a[href='/checkboxes']")),
        CONTEXT_MENU_PAGE(By.cssSelector("a[href='/context_menu']")),
        DRAG_AND_DROP_PAGE(By.cssSelector("a[href='/drag_and_drop']")),
        DROPDOWN_PAGE(By.cssSelector("a[href='/dropdown']")),
        DYNAMIC_CONTENT(By.cssSelector("a[href='/dynamic_content']")),

        NEW_TAB_PAGE(By.cssSelector("a[href='/windows']"));


        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }


    public void clickOnFormAuthentication() {
        driver.findElement(Using.LOGIN_PAGE.selector()).click();
    }

    public void clickOnCheckBoxes(){
        driver.findElement(Using.CHECK_BOXES_PAGE.selector()).click();
    }

    public void clickOnContextMenuPage(){
        driver.findElement(Using.CONTEXT_MENU_PAGE.selector()).click();
    }

    public void clickOnDragAndDropPage(){
        driver.findElement(Using.DRAG_AND_DROP_PAGE.selector()).click();
    }

    public void clickOnDropDownPage(){
        driver.findElement(Using.DROPDOWN_PAGE.selector()).click();
    }

    public void clickOnDynamicContentPage(){
        driver.findElement(Using.DYNAMIC_CONTENT.selector()).click();
    }

    public void clickOnMultipleWindowsLink() {
        driver.findElement(Using.NEW_TAB_PAGE.selector()).click();
    }
}
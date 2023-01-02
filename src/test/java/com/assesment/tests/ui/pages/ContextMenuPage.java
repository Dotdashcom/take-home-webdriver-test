package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    WebDriver driver;

    public ContextMenuPage(WebDriver driver){
        this.driver=driver;
    }

    public enum Using {
        RIGHT_CLICK_LOCATION_BOX(By.id("hot-spot"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    /**
     *  clicks on <b>checkbox 1</b>
     */
    public WebElement testboxWebElement(){
        return driver.findElement(Using.RIGHT_CLICK_LOCATION_BOX.selector());
    }

    public void rightClickOnTextBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(testboxWebElement()).perform();
    }

}

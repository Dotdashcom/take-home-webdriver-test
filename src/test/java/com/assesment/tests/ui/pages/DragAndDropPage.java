package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;

    public DragAndDropPage(WebDriver driver){
        this.driver=driver;
    }

    public enum Using {
        COLUMN_A(By.id("column-a")),
        COLUMN_B(By.id("column-b"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    /**
     *  clicks on <b>Column A</b> for dragging
     * @return WebElement of column a
     */
    public WebElement fromDragColumnA(){
        return driver.findElement(Using.COLUMN_A.selector());
    }

    /**
     * clicks on <b>Column A</b> for dragging
     * @return WebElement of column b
     */
    public WebElement toDropColumnB(){
        return driver.findElement(Using.COLUMN_B.selector());
    }

    /**
     * clicks on column a and drags and drops on column b
     */
    public void dragAndDrop(){
        Actions actions = new Actions(driver);
        actions.clickAndHold(fromDragColumnA())
                .moveToElement(toDropColumnB())
                .release(toDropColumnB())
                .build()
                .perform();
    }

}

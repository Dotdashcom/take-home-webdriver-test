package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageObjectBase {

    @FindBy(xpath = "//div[@id='column-a']")
    WebElement elementA;

    @FindBy(xpath = "//div[@id='column-b']")
    WebElement elementB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragAndDropAOverB() throws Exception {
        Utils.DragAndDropJS(elementA, elementB, driver);
        return this;
    }

    public Boolean verifyDragAndDrop() {
        String elementAHeader = elementA.findElement(By.xpath("descendant::header")).getText();
        String elementBHeader = elementB.findElement(By.xpath("descendant::header")).getText();
        return elementAHeader.equals("B") && elementBHeader.equals("A");
    }

}

package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.openqa.selenium.WebElement;


public class DragDropPage {

    public void performDragAndDrop() {
        I.amPerforming().dragAndDropInHtml5(getDragBox(), getDropBox());
        I.amPerforming().threadWait(1000);
    }

    public void assertDragAndDrop(String boxName) {
        I.amPerforming().isDisplayed("//div[@id='column-b']//header[text()='" + boxName + "']");
    }

    private WebElement getDragBox() {
        return I.amPerforming().getWebElement("//div[@id='column-a']");
    }

    private WebElement getDropBox() {
        return I.amPerforming().getWebElement("//div[@id='column-b']");
    }


}

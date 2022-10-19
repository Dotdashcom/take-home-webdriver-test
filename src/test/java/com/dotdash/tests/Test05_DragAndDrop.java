package com.dotdash.tests;

import com.dotdash.pages.DragAndDropPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test05_DragAndDrop {

    /**
     * Test drags element A to element B.
     * Test asserts that the text on element A and B are switched.
     */

    @Test
    public void dragAndDropTest() {

        DragAndDropPage dragAndDropPage = new DragAndDropPage();

        String url = ConfigurationReader.getProperty("base.url") + "/drag_and_drop";
        Driver.getDriver().get(url);

        Assert.assertEquals(dragAndDropPage.elementA.getText(),"A");
        Assert.assertEquals(dragAndDropPage.elementB.getText(),"B");

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dragAndDropPage.elementA, dragAndDropPage.elementB).perform();

//        actions.moveToElement(dragAndDropPage.elementA)
//                .clickAndHold()
//                .moveToElement(dragAndDropPage.elementB)
//                .release().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.textToBePresentInElement(dragAndDropPage.elementA, "B"));

        Assert.assertEquals(dragAndDropPage.elementA.getText(),"B");
        Assert.assertEquals(dragAndDropPage.elementB.getText(),"A");

        Driver.closeDriver();

    }

}

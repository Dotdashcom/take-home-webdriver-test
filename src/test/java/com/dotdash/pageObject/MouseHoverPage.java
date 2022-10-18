package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class MouseHoverPage {

    public void hoverMouseOnFigure(String figureNumber) {
        I.amPerforming().mouseActions().moveToElement(I.amPerforming().getWebElement("//div[@class='figure'][" + figureNumber + "]")).build().perform();
    }

    public void assertDataAfterHover(String figureNumber) {
        Assert.assertTrue(I.amPerforming().isDisplayed("//div[@class='figcaption'][" + figureNumber + "]//*[text()='name: user" + figureNumber + "']"));
    }
}

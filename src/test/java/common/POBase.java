package common;

import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class POBase {
    protected WebElement getElement(By by){
        return BrowserUtil.GetDriver().findElement(by);
    }

    protected Boolean isElementPresent(By by){
        return BrowserUtil.GetDriver().findElements(by).size() > 0;
    }
}

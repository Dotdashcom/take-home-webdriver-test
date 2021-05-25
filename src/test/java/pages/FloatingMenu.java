package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class FloatingMenu extends POBase {
    public void verifyFloatingMenu(){
        String idValue = "menu";
        Assert.assertTrue(isElementPresent(By.id(idValue)));
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtil.GetDriver();
        for(int i=0; i<2; i++){
            js.executeScript("window.scrollBy(0,1000)");
            Assert.assertTrue(getElement(By.id(idValue)).isDisplayed());
        }
    }
}

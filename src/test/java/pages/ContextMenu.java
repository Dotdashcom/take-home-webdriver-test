package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ContextMenu extends POBase {
    public void clickAndAssertContextMenu(){
        WebDriver driver = BrowserUtil.GetDriver();
        Actions actions = new Actions(driver);
        var contextElement = getElement(By.id("hot-spot"));
        actions.contextClick(contextElement).perform();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu");
        driver.switchTo().alert().accept();
    }
}

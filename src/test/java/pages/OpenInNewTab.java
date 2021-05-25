package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class OpenInNewTab extends POBase {
    public void verifyOpenInNewTab(){
        WebDriver driver = BrowserUtil.GetDriver();
        String tab1 = driver.getWindowHandle();
        getElement(By.linkText("Click Here")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(tab1);
        driver.switchTo().window(newTab.get(0));
        Assert.assertTrue(isElementPresent(By.xpath("//h3[text()='New Window']")));
        driver.close();
        driver.switchTo().window(tab1);
    }
}

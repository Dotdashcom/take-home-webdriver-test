package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseHover extends POBase {
    public void verifyMouseHover(){
        Actions actions = new Actions(BrowserUtil.GetDriver());
        WebElement image1 = getElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(image1).perform();
        Assert.assertTrue(getElement(By.xpath("//h5[text()='name: user1']")).isDisplayed());
        WebElement image2 = getElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        actions.moveToElement(image2).perform();
        Assert.assertTrue(getElement(By.xpath("//h5[text()='name: user2']")).isDisplayed());
        WebElement image3 = getElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
        actions.moveToElement(image3).perform();
        Assert.assertTrue(getElement(By.xpath("//h5[text()='name: user3']")).isDisplayed());
    }
}

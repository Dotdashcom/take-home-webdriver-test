package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDrop extends POBase {
    public void dragDropVerify(){
        var box1 = getElement(By.id("column-a"));
        var box2 = getElement(By.id("column-b"));
        var box1Header = getElement(By.xpath("//div[@id='column-a']/header"));
        var box2Header = getElement(By.xpath("//div[@id='column-b']/header"));
        String header1 = box1Header.getText();
        String header2 = box2Header.getText();
        //Actions actions = new Actions(BrowserUtil.GetDriver());
        //actions.dragAndDrop(box1, box2).build().perform();
        Actions builder = new Actions(BrowserUtil.GetDriver());
        builder.dragAndDrop(box1, box2).perform();
        /**Action dragAndDrop = builder.clickAndHold(box1Header)
                .moveToElement(box2Header)
                .release(box2Header)
                .build();
        dragAndDrop.perform();**/

        Assert.assertEquals(box1Header.getText(), header2);
        Assert.assertEquals(box2Header.getText(), header1);
    }

    public void dragDropVerify2(){
        WebElement box1 = getElement(By.id("column-a"));
        WebElement box2 = getElement(By.id("column-b"));
        WebElement box1Header = getElement(By.xpath("//div[@id='column-a']/header"));
        WebElement box2Header = getElement(By.xpath("//div[@id='column-b']/header"));
        String header1 = box1Header.getText();
        String header2 = box2Header.getText();
        Actions action = new Actions(BrowserUtil.GetDriver());
        action.clickAndHold(box1).build().perform();
        action.moveToElement(box2).build().perform();
        action.release(box2).build().perform();
        //action.dragAndDrop(box1, box2).build().perform();
        //Assert.assertEquals(box1Header.getText(), header2);
        //Assert.assertEquals(box2Header.getText(), header1);
        String header12 = getElement(By.xpath("//div[@id='columns']/div[1]/header")).getText();
        String header22 = getElement(By.xpath("//div[@id='columns']/div[2]/header")).getText();
        Assert.assertEquals(header12, header2);
        Assert.assertEquals(header22, header1);
    }
}

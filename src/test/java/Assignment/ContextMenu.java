package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends TestBase {

    @Test
    public void contextMenuRightClickAlertTest() throws InterruptedException {

        driver.get(baseUrl + "/context_menu");



        WebElement placeOfTheBox = driver.findElement(By.xpath("//div[@class='example']//div[@id='hot-spot']"));

        getActions().contextClick(placeOfTheBox).perform();


        if (getWait().until(ExpectedConditions.alertIsPresent()) != null) {
            String expectedText = "You selected a context menu";
            Assert.assertEquals(driver.switchTo().alert().getText() , expectedText , "alert message incorrect");
        } else {
            Assert.fail("alert is not present");
        }




    }
}

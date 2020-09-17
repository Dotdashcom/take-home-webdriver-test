package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class FloatingMenuTests extends TestBase {

    String url="floating_menu";

    @Test
    public void floatingMenu(){
        Driver.setUp(url);
        List<WebElement>lst=new ArrayList<>();
        for(int a=1; a<=4; a++){
            lst.add(Driver.getDriver().findElement(By.xpath("//ul/li["+a+"]")));
        }
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        for(WebElement i:lst){
            Assert.assertTrue(i.isDisplayed());
        }

    }
}

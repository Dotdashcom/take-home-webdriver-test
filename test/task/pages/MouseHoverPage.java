package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class MouseHoverPage extends PageBase{
    public void hoverOver(){

        for(int i=1;i<4;i++){
            WebElement user = driver.findElement(By.xpath("//*[@id='content']/div/div["+i+"]"));
            actions.moveToElement(user).perform();
            BrowserUtils.wait(2);
            WebElement message = driver.findElement(By.xpath("//a[@href='/users/"+i+"']"));
            Assert.assertTrue(message.isDisplayed());
            BrowserUtils.wait(2);
        }
    }



}

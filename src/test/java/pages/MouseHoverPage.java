package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class MouseHoverPage extends PageBase {

//    @FindBy(xpath = "//*[@id='content']/div/div[1]")
//    protected WebElement firstUser;
//
//    @FindBy(xpath = "//*[text()='name: user1']")
//    protected WebElement firstMessage;

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

package webdrivertestpages;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHover extends Base {
    WebDriver driver;
    @FindBy(xpath = "(//img[@src='/img/avatar-blank.jpg'])[1]")
    WebElement target;
    Boolean isDisplay;

    public MouseHover(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void mouseHover(){

       // WebElement target2 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
       // WebElement target3 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        Actions ac = new Actions(driver);
        ac.moveToElement(target).build().perform();
        isDisplay = target.isDisplayed();
    }

    public Boolean isHoverDisplay(){
        return isDisplay;
    }
}

package webdrivertestpages;

import common.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DragAndDrop extends Base {
    WebDriver driver;

    @FindBy(xpath = "//div[@id='column-a']" )
    WebElement source;
    @FindBy(xpath = "//div[@id='column-b']")
    WebElement target;

    public DragAndDrop(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void dragAndDrop(){
        Actions ac = new Actions(driver);
        ac.dragAndDrop(source, target).build().perform();
    }

    public Boolean isDropped(){
        String textTo = target.getText();
        if(textTo.equals("B"))
            return true;
        else
            return false;
    }

}

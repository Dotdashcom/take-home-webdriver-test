package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDrop {
    public DragAndDrop(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //    @FindBy(xpath="//div[@id='column-a']")
//    WebElement boxA;
//    @FindBy(xpath="//div[@id='column-b']")
//    WebElement boxB;
    @FindBy(xpath = "//header[.='A']")
    WebElement boxA;
    @FindBy(xpath = "//header[.='B']")
    WebElement boxB;

    public String atoB(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(boxA, boxB).build().perform();
        WebElement elementB = driver.findElement(By.id("column-b"));
        return elementB.getText();
    }
//    //public String isDragAndDrop(){
//        return boxB.getText();
//    }


}

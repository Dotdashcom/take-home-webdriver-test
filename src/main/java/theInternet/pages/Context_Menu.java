package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Context_Menu {

    public Context_Menu(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Context Menu")
    WebElement contextMenu;

    @FindBy(id ="hot-spot")
    WebElement rightClickBox;


    public void clickContext(WebDriver driver) throws InterruptedException {
        contextMenu.click();
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.contextClick(rightClickBox).perform();

    }

    public void interactAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }


}

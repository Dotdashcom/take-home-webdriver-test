package framework.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContextMenuPage {
    WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "hot-spot")
    WebElement dashedBoxField;

    public void verifyJavaScriptAlert(){
        Actions dashedBox = new Actions(driver);
        try {
            WebElement element = driver.findElement(By.id("hot-spot"));
            dashedBox.contextClick(element).build().perform();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals("You selected a context menu", alertText);
            alert.accept();
        } catch (NoSuchElementException e){
            Assert.fail("No element with " + dashedBoxField);
        }


    }

}

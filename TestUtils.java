import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class TestUtils {


    public void enterTextToTextBox(WebDriver driver, String id, String text){
        driver.findElement(By.id(id)).sendKeys(text);
    }
    public void clickButton(WebDriver driver, String text){
        driver.findElement(By.className(text)).click();
    }
    public void checkOrUncheckCheckbox(WebDriver driver, String text){
        driver.findElement(By.xpath(text)).click();
    }

    public void rightClick(WebDriver driver, String id, Actions actions){
        WebElement contextMenu = driver.findElement(By.id(id));
        actions.contextClick(contextMenu).perform();
    }

    public void dropDownSelection(WebDriver driver, String id, String option, Actions actions){
        Select dropDown = new Select(driver.findElement(By.id(id)));
        dropDown.selectByValue(option);
    }

    public void dragAndDrop(WebDriver driver, String id , String toId, Actions actions){
        WebElement elementFrom = driver.findElement(By.id(id));
        WebElement elementTo = driver.findElement(By.id(toId));
        actions.dragAndDrop(elementFrom,elementTo).perform();

    }

    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public void download(WebDriver driver, String text){
        driver.findElement(By.linkText(text)).click();
    }

}

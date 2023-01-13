package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends Base {
    WebDriver driver;

    String figure = readValue("hoversPage.figureXp");
    String figCaption = readValue("hoversPage.figCaptionXp");

    public boolean areCaptionsDisplayed() {
        List<WebElement> figures = driver.findElements(By.xpath(figure));
        Actions act = new Actions(driver);
        boolean displayed = true;
        //Mouse over in every element
        //if at least one caption is not displayed, the function will return false
        for (int i = 1; i <= figures.size(); i++) {
            WebElement fig = driver.findElement(By.xpath(figure + "[" + i + "]"));
            act.moveToElement(fig).perform();
            WebElement figCap = driver.findElement(By.xpath(figCaption + "[" + i + "]"));
            if (figCap.isDisplayed() && displayed) {
                displayed = figCap.isDisplayed();
            }
        }
        return displayed;
    }

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }
}

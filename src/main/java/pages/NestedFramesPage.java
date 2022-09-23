
package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends AbstractWebPage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromLeftFrame() {
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
        String innerText = driver.findElement(By.cssSelector("body")).getText();
        driver.switchTo().defaultContent();
        return innerText;
    }

    public String getTextFromMiddleFrame() {
        driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");
        String innerText = driver.findElement(By.cssSelector("#content")).getText();
        driver.switchTo().defaultContent();
        return innerText;
    }

    public String getTextFromRightFrame() {
        driver.switchTo().frame("frame-top").switchTo().frame("frame-right");
        String innerText = driver.findElement(By.cssSelector("body")).getText();
        driver.switchTo().defaultContent();
        return innerText;
    }

    public String getTextFromBottomFrame() {
        driver.switchTo().frame("frame-bottom");
        String innerText = driver.findElement(By.cssSelector("body")).getText();
        driver.switchTo().defaultContent();
        return innerText;
    }
}
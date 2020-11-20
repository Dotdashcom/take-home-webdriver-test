package pageobjects.ContextMenu;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

public class ContextMenu {
    protected WebDriver driver;
    private static final long DEFAULT_PAUSE = 2000;
    private static By byHotSpot = By.id("hot-spot");

    public ContextMenu(WebDriver driver){
        this.driver = driver;
    }

    public String clkTheInternetSpot() throws InterruptedException {
        Actions actions = new Actions(driver);
        String alertMsg = "";

        try {
            WebElement elHotSpot = driver.findElement(byHotSpot);
            actions.contextClick(elHotSpot).perform();

            alertMsg = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(DEFAULT_PAUSE);

        return alertMsg;
    }

}

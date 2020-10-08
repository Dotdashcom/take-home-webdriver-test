package regression.ui.model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public final class ContextMenuPage extends WebObject {
    public ContextMenuPage(WebDriver driver) throws Exception {
        super(driver);
        // Waits for page to load
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static ContextMenuPage navigateToContextMenuPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/context_menu", baseUrl);
        driver.get(url);
        return new ContextMenuPage(driver);
    }

    public String getTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public Alert rightClickBox() {
        WebElement box = driver.findElement(By.xpath(this.xpathForBox()));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        return driver.switchTo().alert();
    }

    private String xpathForBox() {
        return "//*[@id=\"hot-spot\"]";
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ContextPage extends BasePage {
    private String path = "/context_menu";

    private By contextBoxBy = By.xpath("//div[@id='hot-spot']");
    private Alert contextAlert;

    public ContextPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void rightClickContextBox() {
        Actions actions = new Actions(driver);
        WebElement contextBox = driver.findElement(contextBoxBy);
        actions.contextClick(contextBox).perform();
    }

    public Alert accessAlert() throws NoAlertPresentException {
        contextAlert = driver.switchTo().alert();
        return contextAlert;
    }

    public String getAlertText() {
        return contextAlert.getText();
    }

    public void closeAlert() {
        contextAlert.accept();
    }
}

package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class DynamicLoadingPage extends WebObject {
    public DynamicLoadingPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static DynamicLoadingPage navigateToDynamicLoadingPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/dynamic_loading/2", baseUrl);
        driver.get(url);
        return new DynamicLoadingPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public DynamicLoadingPage clickStart() throws Exception {
        By buttonLocator = By.xpath(this.xpathForStartButton());
        WebElement startButton = driver.findElement(buttonLocator);
        startButton.click();
        this.waitForElementInvisibility(buttonLocator);
        return this;
    }

    public String getMessageAfterLoading() throws Exception {
        By messageLocator = By.xpath(this.xpathForMessage());
        this.waitForElementVisibility(messageLocator);
        return driver.findElement(By.xpath(this.xpathForMessage())).getText();
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForStartButton(){
        return "//button[text()= \"Start\"]";
    }

    private String xpathForMessage(){
        return "//*[@id=\"finish\"]";
    }
}

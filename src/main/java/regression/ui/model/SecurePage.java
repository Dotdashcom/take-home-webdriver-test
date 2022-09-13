package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class SecurePage extends WebObject {
    public SecurePage(WebDriver driver) throws Exception {
        super(driver);
        // Waits for page to load
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public String getFlashMessage() {
        return driver.findElement(By.xpath(this.xpathForFlashMessage())).getText();
    }

    public String getTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public LoginPage clickLogout() throws Exception {
        WebElement logoutButton = driver.findElement(By.xpath(this.xpathForLogoutButton()));
        logoutButton.click();
        return new LoginPage(driver);
    }

    private String xpathForFlashMessage() {
        return "//*[@id = \"flash-messages\"]";
    }

    private String xpathForPageTitle() {
        return "//h2";
    }

    private String xpathForLogoutButton() {
        return "//*[@class=\"button secondary radius\"]";
    }
}

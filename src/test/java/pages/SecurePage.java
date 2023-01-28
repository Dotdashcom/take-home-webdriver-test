package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage {
    @FindBy(xpath = "//h2")
    private WebElement secureAreaTitle;

    @FindBy(id = "flash")
    private WebElement successAlertMessage;

    @FindBy(xpath = "//div[@id='flash']/a")
    private WebElement closeAlertButton;

    @FindBy(className = "subheader")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    public void logout() {
        logoutButton.click();
    }

    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(secureAreaTitle.isDisplayed());
        Assertions.assertTrue(successAlertMessage.isDisplayed());
        Assertions.assertTrue(closeAlertButton.isDisplayed());
        Assertions.assertTrue(logoutButton.isDisplayed());
    }

    public void assertWelcomeMessage(String expectedMessage) {
        Assertions.assertEquals(welcomeMessage.getText(), expectedMessage);
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(secureAreaTitle.getText(), expectedTitle);
    }

    public SecurePage(WebDriver webDriver) {
        super(webDriver);
    }
}

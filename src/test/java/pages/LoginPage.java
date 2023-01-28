package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h2")
    private WebElement loginPageTitle;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "flash")
    private WebElement errorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void assertInputsAreCleared() {
        String userNameField = userNameInput.getAttribute("value");
        String passwordField = passwordInput.getAttribute("value");

        Assertions.assertTrue(userNameField.isEmpty());
        Assertions.assertTrue(passwordField.isEmpty());
    }

    public void assertErrorMessage(String expectedErrorMessage) {
        waitForElementToBeVisible(errorMessage);
        Assertions.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
    }

    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(userNameInput.isDisplayed());
        Assertions.assertTrue(passwordInput.isDisplayed());
        Assertions.assertTrue(submitButton.isDisplayed());
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(loginPageTitle.getText(), expectedTitle);
    }

    public void authorize(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

}

package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkbox")
    public List<WebElement> checkBoxes;

    @FindBy(id = "loading")
    public WebElement loadingIcon;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement textBox;

    public boolean checkboxesAreDisplayed() {
        return checkBoxes.size() > 0;
    }

    public void waitLoadingIconToDisappear() {
        waitForElementToDisappear(loadingIcon);
    }

    public void assertCheckboxesAre(String status) {
        if (status.equalsIgnoreCase("displayed")) {
            Assert.assertTrue(checkboxesAreDisplayed());
        } else if (status.equalsIgnoreCase("not displayed")) {
            Assert.assertFalse(checkboxesAreDisplayed());
        }
    }

    public void waitTextBoxToBeEnabled() {
        waitForElementToBeClickable(textBox);
    }

    public void waitTextBoxNotToBeEnabled() throws InterruptedException {
        int attempts = 0;

        do {
            if (textBox.isEnabled()) {
                Thread.sleep(1000);
                attempts++;
            } else if (!textBox.isEnabled()) {
                break;
            }
        } while (attempts < 30);
    }
}

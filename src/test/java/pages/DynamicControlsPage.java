package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestSetUp;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    public DynamicControlsPage() {
        url = "http://localhost:7080/dynamic_controls";
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//form[@id='checkbox-example']/button[@type='button']")
    private WebElement removeOrAddButton;

    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingBar;

    @FindBy(xpath = "//form[@id='input-example']/button[@type='button']")
    private WebElement enableOrDisableButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputField;


    public void clickRemoveOrAddButton() {
        removeOrAddButton.click();
        getWait(10).until(ExpectedConditions.invisibilityOf(loadingBar));
    }

    public static boolean isDisplayed(WebElement elem) {
        try {
            WebDriverWait wait = new WebDriverWait(TestSetUp.getDriver(), Duration.ofSeconds(5));
            return wait.until((ExpectedCondition<Boolean>) driver -> {
                if (elem.isDisplayed()) {
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckboxDisplayed() {
        if (!isDisplayed(checkbox)) {
            return true;
        }
        return false;
    }

    public void clickEnableOrDisableButton() {
        removeOrAddButton.click();
        getWait(10).until(ExpectedConditions.invisibilityOf(loadingBar));

    }

    public boolean isEnabled() {
        if (!inputField.isEnabled()) {
            return false;
        }
        return true;
    }
}

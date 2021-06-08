package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPageObject extends BasePageObject {
    @FindBy(id = "checkbox")
    private WebElement checkBox;
    @FindBy(css = "form[id='checkbox-example'] button")
    private WebElement addOrRem;
    @FindBy(css = "form[id='input-example'] input")
    private WebElement input;
    @FindBy(css = "form[id='input-example'] button")
    private WebElement enableOrDis;

    public DynamicControlsPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public DynamicControlsPageObject clickRem() {
        addOrRem.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        return this;
    }

    public DynamicControlsPageObject clickAdd() {
        addOrRem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        return this;
    }

    public DynamicControlsPageObject clickEnable() {
        enableOrDis.click();
        wait.until(ExpectedConditions.elementToBeClickable(input));
        return this;
    }

    public DynamicControlsPageObject clickDisable() {
        enableOrDis.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
        return this;
    }

    public boolean isCheckBoxPresent() {
        try {
            getDriver().findElement(By.id("checkbox"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInputEnabled() {
        return input.isEnabled();
    }

}

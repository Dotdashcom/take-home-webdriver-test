package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends AbstractWebPage {

    @FindBy(css = "form#checkbox-example > button")
    protected WebElement addAndRemoveButtonElm;

    @FindBy(css = "form#input-example > button")
    protected WebElement enableAndDisableButtonElm;

    @FindBy(css = "form#input-example > input")
    protected WebElement inputTextElm;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void removeCheckBox() {
        addAndRemoveButtonElm.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
    }

    public void addCheckBox() {
        addAndRemoveButtonElm.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
    }

    public void enableInputField() {
        enableAndDisableButtonElm.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")));
    }

    public void disableInputField() {
        enableAndDisableButtonElm.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"It's disabled!\"]")));
    }


}



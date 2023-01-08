package model;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.base.BasePage;

public class ContextMenuPage extends BasePage {

    private static final String CONTEXT_MENU_ENDPOINT = "context_menu";

    @FindBy(css = "#hot-spot")
    private WebElement contextMenuArea;

    @FindBy(css = "h3")
    private WebElement contextMenuHeader;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage getContextMenuPage() {
        getDriver(CONTEXT_MENU_ENDPOINT);

        return new ContextMenuPage(getDriver());
    }

    public ContextMenuPage rightClickContextMenuArea() {
        getAction().moveToElement(contextMenuArea).contextClick().perform();

        return this;
    }

    public String getAlertMessageText() {

        return getDriver().switchTo().alert().getText();
    }

    public String getHeaderText() {

        return contextMenuHeader.getText();
    }

    public boolean isHeaderDisplayed() {

        return contextMenuHeader.isDisplayed();
    }

    public ContextMenuPage clickOkAlertMessage() {
        getDriver().switchTo().alert().accept();

        return this;
    }

    public boolean isAlertPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch(NoAlertPresentException e) {
            e.fillInStackTrace();
            return false;
        }
    }
}
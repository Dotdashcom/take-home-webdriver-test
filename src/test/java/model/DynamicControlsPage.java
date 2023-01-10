package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    private static final String DYNAMIC_CONTROLS_ENDPOINT = "dynamic_controls";

    @FindBy(css = "input[type=checkbox]")
    private WebElement checkbox;

    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//form[@id='checkbox-example']//button//preceding-sibling::div/input")
    private List<WebElement> checkboxAlternativeLocatorRelativeToButtonList;

    @FindBy(css = "#checkbox-example button")
    private WebElement addRemoveCheckboxButton;

    @FindBy(css = "#checkbox-example img[src*='ajax-loader']")
    private WebElement addRemoveCheckboxWaitBarImage;

    @FindBy(css = "#checkbox-example #message")
    private WebElement addRemoveCheckboxResultMessage;

    @FindBy(css = "p")
    private List<WebElement> addRemoveCheckboxResultMessageList;

    @FindBy(css = "#checkbox-example #loading")
    private WebElement addRemoveCheckboxLoadingMessage;

    @FindBy(css = "input[type=text]")
    private WebElement textArea;

    @FindBy(css = "#input-example button")
    private WebElement enableDisableTextAreaButton;

    @FindBy(css = "#input-example img[src*='ajax-loader']")
    private WebElement enableDisableTextAreaWaitBarImage;

    @FindBy(css = "#input-example #message")
    private WebElement enableDisableTextAreaResultMessage;

    @FindBy(css = "#input-example #loading")
    private WebElement enableDisableTextAreaLoadingMessage;

    @FindBy(css = "p")
    private List<WebElement> pTagList;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage getDynamicControlsPage() {
        getDriver(DYNAMIC_CONTROLS_ENDPOINT);

        return new DynamicControlsPage(getDriver());
    }

    public DynamicControlsPage clickCheckbox() {
        checkbox.click();

        return new DynamicControlsPage(getDriver());
    }

    public boolean isCheckboxSelected() {

        return checkbox.isSelected();
    }

    public String getAddRemoveCheckboxButtonText() {

        return addRemoveCheckboxButton.getText();
    }

    public DynamicControlsPage clickAndWaitAddRemoveCheckboxButton() {
        addRemoveCheckboxButton.click();
        getWait(5).until(ExpectedConditions.visibilityOf(addRemoveCheckboxResultMessage));

        return new DynamicControlsPage(getDriver());
    }

    public DynamicControlsPage clickAddRemoveCheckboxButton() {
        addRemoveCheckboxButton.click();

        return new DynamicControlsPage(getDriver());
    }

    public boolean isCheckboxDisplayed() {

        return checkbox.isDisplayed();
    }

    public boolean isCheckboxNotDisplayed() {

        return checkboxList.size() == 0;
    }

    public boolean isCheckboxChangedLocationToButton() {

        return checkboxAlternativeLocatorRelativeToButtonList.size() == 0;
    }

    public boolean isAddRemoveCheckboxWaitbarImageDisplayed() {

        return addRemoveCheckboxWaitBarImage.isDisplayed();
    }

    public boolean isAddRemoveCheckboxLoadingMessageDisplayed() {

        return addRemoveCheckboxLoadingMessage.isDisplayed();
    }

    public String getAddRemoveCheckboxLoadingMessageText() {

        return addRemoveCheckboxLoadingMessage.getText();
    }

    public boolean isAddRemoveCheckboxResultMessageDisplayed() {

        return addRemoveCheckboxResultMessage.isDisplayed();
    }

    public boolean isAddRemoveCheckboxResultMessageNotDisplayed() {

        return addRemoveCheckboxResultMessageList.size() == 1;
    }

    public String getAddRemoveCheckboxResultMessageText() {

        return addRemoveCheckboxResultMessage.getText();
    }

    public DynamicControlsPage inputTextAreaText(String inputText) {
        getAction().moveToElement(textArea).click().sendKeys(inputText).perform();

        return new DynamicControlsPage(getDriver());
    }

    public String getTextFromTextArea() {

        return textArea.getAttribute("value");
    }
    public boolean isTextAreaEnabled() {

        return textArea.isEnabled();
    }

    public String getTextAreaDisabledStatus() {

        return textArea.getAttribute("disabled");
    }

    public boolean isAddRemoveCheckboxEnableDisableTextAreaWaitbarImageDisplayed() {

        return enableDisableTextAreaWaitBarImage.isDisplayed();
    }

    public boolean isEnableDisableTextAreaWaitbarImageDisplayed() {

        return enableDisableTextAreaWaitBarImage.isDisplayed();
    }

    public boolean isEnableDisableTextAreaLoadingMessageDisplayed() {

        return enableDisableTextAreaLoadingMessage.isDisplayed();
    }

    public String getEnableDisableTextAreaLoadingMessageText() {

        return enableDisableTextAreaLoadingMessage.getText();
    }

    public boolean isEnableDisableTextAreaResultMessageDisplayed() {

    return enableDisableTextAreaResultMessage.isDisplayed();
    }

    public String getEnableDisableButtonText() {

        return enableDisableTextAreaButton.getText();
    }

    public DynamicControlsPage clickAndWaitEnableDisableTextAreaButton() {
        enableDisableTextAreaButton.click();
        getWait(5).until(ExpectedConditions.visibilityOf(enableDisableTextAreaResultMessage));

        return new DynamicControlsPage(getDriver());
    }
    public DynamicControlsPage clickEnableDisableTextAreaButton() {
        enableDisableTextAreaButton.click();

        return new DynamicControlsPage(getDriver());
    }

    public boolean isEnableDisableTextAreaResultMessageNotDisplayed() {

        return pTagList.size() == 1;
    }

    public String getEnableDisableTextAreaResultMessageText() {

        return enableDisableTextAreaResultMessage.getText();
    }
}
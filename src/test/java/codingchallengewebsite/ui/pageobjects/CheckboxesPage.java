package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class CheckboxesPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Checkboxes']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    public List<WebElement> checkboxElements;
    private final HashMap<Integer, Boolean> expectedValues = new HashMap<>();
    private final HashMap<Integer, Boolean> currentValues = new HashMap<>();
    private final WebDriverWait genericWait;
    private final String pageUrl;
    private final UITest caller;

    public CheckboxesPage(UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/checkboxes";
        this.caller.getDriver().get(this.pageUrl);
        this.genericWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        this.currentValues.put(0, this.checkboxElements.get(0).isSelected());
        this.currentValues.put(1, this.checkboxElements.get(1).isSelected());
        this.expectedValues.put(0, !this.checkboxElements.get(0).isSelected());
        this.expectedValues.put(1, !this.checkboxElements.get(1).isSelected());
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public Boolean clickOnCheckbox(Integer checkbox) {
        return performClickOnCheckbox(checkbox, updateOnClick); }

    public Boolean getCheckboxExpectedValue(Integer checkbox) {
        return this.expectedValues.get(checkbox); }

    public Boolean getCheckboxCurrentValue(Integer checkbox) {
        return this.currentValues.get(checkbox); }

    private Boolean performClickOnCheckbox(Integer parameter, @NotNull Function<Integer, Boolean> updateOnClick) {
        return updateOnClick.apply(parameter); }

    Function<Integer, Boolean> updateOnClick = parameter -> {
        Boolean previousValue = this.getCheckboxCurrentValue(parameter);
        this.clickCheckbox(parameter);
        this.currentValues.put(parameter, this.checkboxElements.get(parameter).isSelected());
        this.expectedValues.put(parameter, !this.checkboxElements.get(parameter).isSelected());
        return previousValue;
    };

    private void clickCheckbox(Integer checkbox) {
        genericWait.until(ExpectedConditions.visibilityOf(checkboxElements.get(checkbox)));
        this.checkboxElements.get(checkbox).click();
    }

    public List<WebElement> getCheckboxElements() {
        return this.checkboxElements;
    }
}
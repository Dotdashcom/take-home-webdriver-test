package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Checkboxes']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][1]")
    private WebElement checkbox1;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][2]")
    private WebElement checkbox2;
    @FindBy(how = How.XPATH, using = "//input[@id = 'username']")
    private WebElement username;

    boolean checkbox1Status;
    boolean checkbox1Expected;
    boolean checkbox2Status;
    boolean checkbox2Expected;
    private final String pageUrl;
    private final UITest caller;

    public CheckboxesPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/checkboxes";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.checkbox1Status = this.isCheckboxSelected("checkbox1");
        this.checkbox1Expected = !this.checkbox1Status;
        this.checkbox2Status = this.isCheckboxSelected("checkbox2");
        this.checkbox2Expected = !this.checkbox2Status;
    }

    public boolean isPageOpen() {
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("Checkboxes"); }

    public boolean getCheckbox1Expected() {
        return this.checkbox1Expected;
    }

    public boolean getCheckbox2Expected() {
        return this.checkbox2Expected;
    }

    public boolean isCheckboxSelected(String checkbox) {
        return switch (checkbox) {
            case "checkbox1" -> checkbox1.isSelected();
            case "checkbox2" -> checkbox2.isSelected();
            default -> false;
        };
    }

    public void clickCheckbox(String checkbox) {
        switch (checkbox) {
            case "checkbox1" -> checkbox1.click();
            case "checkbox2" -> checkbox2.click();
        }
    }
}
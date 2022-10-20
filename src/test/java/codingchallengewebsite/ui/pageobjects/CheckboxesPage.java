package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

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
    public WebDriver driver;
    private UITests caller;

    public CheckboxesPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/checkboxes").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.checkbox1Status = this.isCheckboxSelected("checkbox1");
        this.checkbox1Expected = !this.checkbox1Status;
        this.checkbox2Status = this.isCheckboxSelected("checkbox2");
        this.checkbox2Expected = !this.checkbox2Status;
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Checkboxes");
    }

    public boolean getCheckbox1Expected() {
        return this.checkbox1Expected;
    }

    public boolean getCheckbox2Expected() {
        return this.checkbox2Expected;
    }

    public boolean isCheckboxSelected(String checkbox) {
        boolean checked = false;

        switch(checkbox) {
            case "checkbox1":
                checked = checkbox1.isSelected();
                break;
            case "checkbox2":
                checked = checkbox2.isSelected();
            break;
        }
        return checked;
    }

    public void clickCheckbox(String checkbox) {
        boolean status = false;

        switch(checkbox) {
            case "checkbox1":
                checkbox1.click();
                break;
            case "checkbox2":
                checkbox2.click();
                break;
        }
    }


}

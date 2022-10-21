package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class DropdownPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dropdown List']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='dropdown']")
    private WebElement dropdown;
    private UITest caller;
    List<WebElement> dropdownOptions;
    private final String pageUrl;

    public DropdownPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(this.caller.getBaseUrl()).append("/dropdown").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        Select dropdwn = new Select(this.dropdown);
        this.dropdownOptions = dropdwn.getOptions();
    }

    public boolean isPageOpen() {
        if (caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Dropdown List")) return true;
        return false;
    }

    public List<String> getDropdownOptions() {
        List<String> dropdwnOptions = new ArrayList<String>();

        for (WebElement webElement : this.dropdownOptions) {
            if (webElement.getAttribute("disabled") == null) dropdwnOptions.add(webElement.getText());
        }
        return dropdwnOptions;
    }

    public void setDropdownOption(String option) {
        Select dropdwn = new Select(this.dropdown);
        dropdwn.selectByVisibleText(option);
    }

    public boolean isDropdownOptionSelected(String option) {
        Select dropdwn = new Select(this.dropdown);
        String selectedOption = dropdwn.getFirstSelectedOption().getText();
        return selectedOption.equals(option);
    }
}
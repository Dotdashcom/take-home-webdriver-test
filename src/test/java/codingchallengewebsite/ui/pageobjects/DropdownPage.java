package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class DropdownPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dropdown List']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//select")
    public WebElement dropdown;
    private final UITest caller;
    private final Select dropdwn;
    List<WebElement> dropdownOptions;
    private final String pageUrl;

    public DropdownPage(UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/dropdown";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        this.dropdwn = new Select(this.dropdown);
        this.dropdownOptions = this.dropdwn.getOptions();
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public List<String> getDropdownOptions() {
        List<String> dropdwnOptions = new ArrayList<>();
        for (WebElement webElement : this.dropdownOptions) {
            if (webElement.getAttribute("disabled") == null) dropdwnOptions.add(webElement.getText());
        }
        return dropdwnOptions;
    }

    public void setDropdownOption(String option) {
        this.dropdwn.selectByVisibleText(option);
    }

    public Boolean isDropdownOptionSelected(String option) {
        return this.dropdwn.getFirstSelectedOption().getText().equals(option);
    }
}
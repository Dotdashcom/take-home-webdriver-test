package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class DropdownPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dropdown List']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='dropdown']")
    private WebElement dropdown;
    private UITests caller;
    List<WebElement> dropdownOptions;
    private final String pageUrl;
    public WebDriver driver;

    public DropdownPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/dropdown").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
        Select dropdwn = new Select(this.dropdown);
        this.dropdownOptions = dropdwn.getOptions();
    }

    public boolean isPageOpen() {
        if (driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Dropdown List")) return true;
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
        if (selectedOption.equals(option)) return true;
        return false;
    }
}

package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DropdownPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dropdown List']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//select")
    public WebElement dropdown;
    private final UITest caller;
    private final Select dropdwn;
    List<WebElement> dropdownOptions;
    private final String pageUrl;

    public DropdownPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/dropdown";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle), visibilityOf(this.dropdown)));
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
        //Select dropdwn = new Select(this.dropdown);
        this.dropdwn.selectByVisibleText(option);
    }

    public Boolean isDropdownOptionSelected(String option) {
        //Select dropdwn = new Select(this.dropdown);
        //String selectedOption = this.dropdwn.getFirstSelectedOption().getText();
        //return selectedOption.equals(option);
        return this.dropdwn.getFirstSelectedOption().getText().equals(option);
    }
}
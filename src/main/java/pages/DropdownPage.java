package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.util.List;
import java.util.Objects;

public class DropdownPage {

    private final By header = By.xpath("//h3[text()='Dropdown List']");
    private final By dropdown = By.id("dropdown");

    public DropdownPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/dropdown");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String VerifyDropdown() {
        UtilitiesManager.ExpectedConditions(dropdown, "DISPLAYED");
        Select Sel = new Select(UtilitiesManager.FindElement(dropdown));

        if (Sel.isMultiple()) {
            Sel.selectByValue("1");
            Sel.selectByValue("2");
        } else {
            System.out.println("This dropdown is not multiple");
            Sel.selectByValue("2");
        }
        List<WebElement> selectedOptions = Sel.getAllSelectedOptions();
        StringBuilder optionsText = new StringBuilder();
        for (WebElement options : selectedOptions) {
            Objects.requireNonNull(optionsText).append(options.getText());

        }

        return optionsText.toString();
    }

}

package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/dropdown";

    private final By pageTitle = By.cssSelector("h3");
    private final By dropdownList = By.id("dropdown");
    private final By optionDisableSelected = By.cssSelector("option[disabled=\"disabled\"][selected=\"selected\"]");
    private final By optionOneSelected = By.cssSelector("option[value=\"1\"][selected=\"selected\"]");
    private final By optionTwoSelected = By.cssSelector("option[value=\"2\"][selected=\"selected\"]");

    public void navigateToDropdownPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/dropdown");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Dropdown");
        boolean checked = validateElementPresence(optionDisableSelected);
        assertThat(checked).isTrue();
    }

    public void selectTheOption(String option) throws Exception {
        Select dropdown = new Select(findElement(dropdownList));
        dropdown.selectByVisibleText(option);
    }

    public void validateTheOptionSelected(String option) {
        if (option.contains("1")) {
            boolean checked = validateElementPresence(optionOneSelected);
            assertThat(checked).isTrue();
        } else {
            boolean checked = validateElementPresence(optionTwoSelected);
            assertThat(checked).isTrue();
        }
    }
}

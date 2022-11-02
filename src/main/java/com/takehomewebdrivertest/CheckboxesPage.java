package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/checkboxes";

    private final By pageTitle = By.cssSelector("h3");
    private final By checkbox1 = By.xpath("//div/form/input[1]");
    private final By checkbox2 = By.xpath("//div/form/input[2]");
    private final By checkedCheckbox1 = By.xpath("//div/form/input[1][@checked]");
    private final By checkedCheckbox2 = By.xpath("//div/form/input[2][@checked]");

    public void navigateToCheckboxesPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/checkboxes");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Checkboxes");
    }

    public void clickOnCheckbox1() throws Exception {
        boolean checked = validateElementPresence(checkedCheckbox1);
        assertThat(checked).isFalse();
        click(checkbox1);
    }

    public void validateThatFirstBoxIsChecked() throws Exception {
        boolean checked = validateElementPresence(checkedCheckbox1);
        assertThat(checked).isTrue();
    }

    public void clickOnCheckbox2() throws Exception {
        boolean checked = validateElementPresence(checkedCheckbox2);
        assertThat(checked).isTrue();
        click(checkbox2);
    }

    public void validateThatSecondBoxIsChecked() throws Exception {
        boolean checked = validateElementPresence(checkedCheckbox2);
        assertThat(checked).isFalse();
    }
}

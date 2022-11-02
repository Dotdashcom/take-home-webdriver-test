package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    ConfigFileReader configFileReader;

    private final String URL = "/windows";
    private final String URL2 = "/new";
    private final By pageTitle = By.cssSelector("h3");
    private final By link = By.cssSelector("a[href=\"/windows/new\"]");

    public void navigateToWindowsPage() throws Exception {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/windows");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Opening a new window");
    }

    public void clickOnLink() throws Exception {
        click(link);
    }

    public void navigateToSecondTab() {
        switchToSecondTab();
    }

    public void validateSecondTabMessage(String message) throws Exception {
        configFileReader = new ConfigFileReader();
        assertThat(getCurrentUrl()).contains(URL + URL2);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains(message);
    }
}

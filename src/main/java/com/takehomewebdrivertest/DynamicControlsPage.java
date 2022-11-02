package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/dynamic_controls";

    private final By pageTitle = By.cssSelector("h4");
    private final By removeAddButton = By.xpath("//form[@id=\"checkbox-example\"]/button");
    private final By message = By.id("message");
    private final By enableDisableButton = By.xpath("//form[@id=\"input-example\"]/button");

    public void navigateToDynamicControlsPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/dynamic_controls");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Dynamic Controls");
    }

    public void clickOnRemoveButton() throws Exception {
        click(removeAddButton);
        waitForElementVisibility(message);
    }

    public void clickOnAddButton() throws Exception {
        click(removeAddButton);
        waitForElementVisibility(message);
    }

    public void waitUntilElementChange(String option) {
        String Message = driver.findElement(message).getText();
        switch (option) {
            case "remove":
                assertThat(Message).contains("It's gone!");
                break;
            case "add":
                assertThat(Message).contains("It's back!");
                break;
            case "enable":
                assertThat(Message).contains("It's enabled!");
                break;
            case "disable":
                assertThat(Message).contains("It's disabled!");
                break;
        }

    }

    public void clickOnEnableButton() throws Exception {
        click(enableDisableButton);
        waitForElementVisibility(message);
    }

    public void clickOnDisableButton() throws Exception {
        click(enableDisableButton);
        waitForElementVisibility(message);
    }
}

package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    ConfigFileReader configFileReader;

    private final String URL = "/iframe";

    private final By pageTitle = By.cssSelector("h3");
    private final By notificationCloseBtn = By.cssSelector("div.tox-notifications-container button");
    private final By frame = By.cssSelector("#mce_0_ifr");
    private final By textArea = By.cssSelector("#tinymce p");
    private final By boldBtn = By.cssSelector("button[title=Bold]");
    private final By alignRightBtn = By.cssSelector("button[title=\"Align right\"]");
    private final By formatBtn = By.xpath("(//button[@role=\"menuitem\"]//span)[4]");
    private final By fontSizeBtn = By.cssSelector("div[title=\"Font sizes\"] div.tox-collection__item-label");
    private final By fontSizept = By.cssSelector("div[title=\"36pt\"]");


    public void navigateToIFramePage() throws Exception {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/iframe");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("An iFrame containing the TinyMCE WYSIWYG Editor");
        click(notificationCloseBtn);
    }

    public void writeIntoTextArea() throws Exception {
        switchToFrame(frame);
        sendKeys(textArea, "Testing the IFrame using Selenium and Java :)");
        threadSleep(5000);
        switchToDefaultFrame();
    }

    public void applyBoldAlignRightAndChangeFontSize() throws Exception {
        click(boldBtn);
        click(alignRightBtn);
        changeFontSize();
        switchToFrame(frame);
        sendKeys(textArea, "Testing the IFrame using Selenium and Java :) but now aligned to the right, bold and Font Size at 36pt");
        threadSleep(5000);
    }

    private void changeFontSize() throws Exception {
        click(formatBtn);
        click(fontSizeBtn);
        click(fontSizept);
    }

    public void verifyChanges() {
    }

}

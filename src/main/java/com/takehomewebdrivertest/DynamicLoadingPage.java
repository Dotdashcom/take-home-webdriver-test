package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicLoadingPage extends BasePage {

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/dynamic_loading/2";

    private final By pageTitle = By.cssSelector("h3");
    private final By startButton = By.xpath("//div[@id=\"start\"]/button");
    private final By message = By.xpath("//div[@id=\"finish\"]/h4");

    public void navigateToDynamicLoadingPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/dynamic_loading/2");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Dynamically Loaded Page Elements");
    }

    public void clickOnStartButton() throws Exception {
        click(startButton);
    }

    public void validateText() throws Exception {
        String Message = driver.findElement(message).getText();
        assertThat(Message).contains("Hello World!");
    }
}

package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurePage extends BasePage {

    public SecurePage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/secure";
    private final By successMessage = By.id("flash");

    public void validateMessage(String message) throws Exception {
        assertThat(getCurrentUrl()).contains(URL);
        String msgText = driver.findElement(successMessage).getText();
        assertThat(msgText).contains(message);
    }
}

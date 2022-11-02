package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/context_menu";

    private final By pageTitle = By.cssSelector("h3");
    private final By squareBox = By.id("hot-spot");

    public void navigateToContextMenuPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/context_menu");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Context Menu");
    }

    public void rightClickOnTheBox() throws Exception {
        rightClick(squareBox);
    }

    public void validateJavaScriptAlert() throws Exception {
        String alertText = handleAlert("Text", "");
        assertThat(alertText).contains("You selected a context menu");
        handleAlert("Accept", "");
    }
}

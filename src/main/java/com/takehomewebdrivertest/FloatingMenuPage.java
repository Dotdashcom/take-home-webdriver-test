package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class FloatingMenuPage extends BasePage {

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/floating_menu";

    private final By pageTitle = By.cssSelector("h3");
    private final By homeBtn = By.cssSelector("#menu a[href=\"#home\"]");
    private final By newsBtn = By.cssSelector("#menu a[href=\"#news\"]");
    private final By contactBtn = By.cssSelector("#menu a[href=\"#contact\"]");
    private final By aboutBtn = By.cssSelector("#menu a[href=\"#about\"]");

    public void navigateToFloatingMenuPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/floating_menu");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Floating Menu");
    }

    public void clickOnButton(String floatingMenu) throws Exception {
        switch (floatingMenu) {
            case "Home":
                click(homeBtn);
                break;
            case "News":
                click(newsBtn);
                break;
            case "Contact":
                click(contactBtn);
                break;
            case "About":
                click(aboutBtn);
                break;
        }
    }


    public void validateUrlChange(String floatingMenu) throws Exception {

        configFileReader= new ConfigFileReader();

        switch (floatingMenu) {
            case "Home":
                assertThat(getCurrentUrl()).contains(URL + "#home");
                break;
            case "News":
                assertThat(getCurrentUrl()).contains(URL + "#news");
                break;
            case "Contact":
                assertThat(getCurrentUrl()).contains(URL + "#contact");
                break;
            case "About":
                assertThat(getCurrentUrl()).contains(URL + "#about");
                break;
        }



    }
}

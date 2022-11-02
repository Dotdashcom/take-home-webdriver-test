package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class HoverMousePage extends BasePage {

    public HoverMousePage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/hovers";

    private final By pageTitle = By.cssSelector("h3");
    private final By figure1 = By.xpath("(//div[@class=\"figure\"])[1]");
    private final By figure2 = By.xpath("(//div[@class=\"figure\"])[2]");
    private final By figure3 = By.xpath("(//div[@class=\"figure\"])[3]");
    private final By additionalInfo1 = By.xpath("(//div[@class=\"figcaption\"])[1]");
    private final By additionalInfo2 = By.xpath("(//div[@class=\"figcaption\"])[2]");
    private final By additionalInfo3 = By.xpath("(//div[@class=\"figcaption\"])[3]");

    public void navigateToHoverMousePage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/hovers");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Hovers");
    }

    public void hoverMouseOverBox(String box) throws Exception {
        int a = Integer.parseInt(box);
        switch (a) {
            case 1:
                hoverMouse(figure1);
                waitForElementVisibility(additionalInfo1);
                break;
            case 2:
                hoverMouse(figure2);
                waitForElementVisibility(additionalInfo2);
                break;
            case 3:
                hoverMouse(figure3);
                waitForElementVisibility(additionalInfo3);
                break;
        }
        threadSleep(2500);

    }

    public void validateAdditionalInformation() {

    }
}

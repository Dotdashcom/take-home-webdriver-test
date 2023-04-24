package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    private String baseUrl = "http://localhost:7080";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}

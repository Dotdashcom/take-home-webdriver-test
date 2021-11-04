package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/dynamic_loading");
        PageFactory.initElements(driver, this);
    }
}

package methods;

import model.DynamicLoadingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingMethod extends GeneralTestMethod{

    private final String dynamicLoadingURL = "http://localhost:7080/dynamic_loading/2";
    DynamicLoadingPage dynamicLoadingPage;

    public void startDynamicLoadingTest() {
        driver.get(dynamicLoadingURL);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        WebElement button = dynamicLoadingPage.buttonComponent();
        clickButton(button);

    }

    public String getAssertText() {
        return dynamicLoadingPage.textComponent().getText();
    }

    public void clickButton(WebElement button) {
        button.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));
    }
}

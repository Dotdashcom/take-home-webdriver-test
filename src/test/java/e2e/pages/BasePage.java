package e2e.pages;

import helpers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class BasePage {
    final ConfigReader configReader = new ConfigReader();
    public String baseURL = configReader.getBaseURL();
    public int elementTimeout = configReader.getElementTimeout();
    public WebDriver driver;

    @FindBy(id="flash")
    WebElement messageElem;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visit(String endpoint){
        driver.get(baseURL+endpoint);
    }

    protected void waitElement(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(elementTimeout))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        try {
            waitElement(element);
            element.click();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void typeText(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public boolean elementHasClass(WebElement element, String className) {
        return Arrays.asList(element.getAttribute("class").split(" ")).contains(className);
    }

    public boolean hasEndpoint(String endpoint) {
        return driver.getCurrentUrl().endsWith(endpoint);
    }

    public String getFlashMessage() {
        return messageElem.getText();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}

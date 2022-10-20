package src.main.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;


    public class BasePage {

        protected WebDriver driver;

        @FindBy(css = "#content > div > h3")
        private WebElement pageHeaderText;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }

        public WebDriver getDriver() {
            return driver;
        }

        protected String getPageHeaderText() {
            return pageHeaderText.getText();
        }

        protected void clickButtonAndWaitUntilFinish(WebElement buttonElm) {
            buttonElm.click();

            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver());
            fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
            fluentWait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.id("loading"))));
        }

        protected void waitUntilFileExists(File file) {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver());
            fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
            fluentWait.until(x -> file.exists());
        }


    }


package pages;

import core.AbstractWebPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DynamicLoadingPage extends AbstractWebPage {

    @FindBy(css = "#content > div > a")
    protected List<WebElement> exampleOptions;

    @FindBy(css = "div[id = start] > button")
    protected WebElement startButtonElm;

    @FindBy(css = "div#finish > h4")
    protected WebElement helloWorldTextElm;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void gotoExampleOption(int index) {
        exampleOptions.get(index).click();
    }

    public void startDynamicLoading() {
        startButtonElm.click();
    }

    public void waitUntilLoadFinish() {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.withTimeout(Duration.ofSeconds(15));
        wait.ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

            public Boolean apply(WebDriver arg0) {

                JavascriptExecutor jsExecutor = (JavascriptExecutor) arg0;

                // Function to check if "Hello World!" is in Viewport or not.
                return (Boolean) (jsExecutor.executeScript(
                "var elem = arguments[0],           " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , helloWorldTextElm));
            }
        };

        wait.until(function);
    }
}

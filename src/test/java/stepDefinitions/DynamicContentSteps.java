package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DynamicContentPage;
import utils.PropertyKeys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DynamicContentSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DynamicContentPage dynamicContentPage;

    public DynamicContentSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        dynamicContentPage = new DynamicContentPage(driver, wait);
    }

    @Given("user navigates to dynamic content page")
    public void navigateToDynamicContentPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/dynamic_content");
        dynamicContentPage.WaitUntilElementVisible(dynamicContentPage.dynamicContentPageHeader);
    }

    public void validateContentChangeOnRefresh() {
        boolean contentChanged = false;
        List<String> beforeImgSource = new ArrayList<String>();
        List<String> beforeContentText = new ArrayList<String>();
        for (WebElement webElement: dynamicContentPage.dynamicContentImages) {
            beforeImgSource.add(webElement.getAttribute("src"));
        }
        for (WebElement webElement: dynamicContentPage.dynamicContentDiv) {
            beforeContentText.add(webElement.getText());
        }
        driver.navigate().refresh();
        for (int i = 0; i < beforeImgSource.size(); i++) {
            String afterImgSource = dynamicContentPage.dynamicContentImages.get(i).getAttribute("src");
            String afterContentText = dynamicContentPage.dynamicContentDiv.get(i).getText();
            if (!afterImgSource.equals(beforeImgSource.get(i)) || !afterContentText.equals(beforeContentText.get(i))) {
                contentChanged = true;
            }
        }
        Assert.assertTrue("Content has not changed", contentChanged);
    }

    @Then("content changes on multiple refresh")
    public void validateContentChangeOnMultipleRefersh() {
        validateContentChangeOnRefresh();
        validateContentChangeOnRefresh();
        validateContentChangeOnRefresh();
    }
}

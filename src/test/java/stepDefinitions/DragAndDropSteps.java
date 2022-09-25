package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DragAndDropPage;
import utils.PropertyKeys;

import java.time.Duration;

public class DragAndDropSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DragAndDropPage dragAndDropPage;

    public DragAndDropSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        dragAndDropPage = new DragAndDropPage(driver, wait);
    }

    @Given("user navigates to drag and drop page")
    public void navigateToDragAndDropPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/drag_and_drop");
        dragAndDropPage.WaitUntilElementVisible(dragAndDropPage.dragAndDropPageHeader);
    }

    @And("user drags box A to box B")
    public void dragAndDropAToB() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragAndDropPage.aBox, dragAndDropPage.bBox).perform();
    }

    @And("user drags box B to box A")
    public void dragAndDropBToA() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragAndDropPage.bBox, dragAndDropPage.aBox).perform();
    }

    @Then("box A is swapped with box B")
    public void validateBoxesAreSwapped() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("B", dragAndDropPage.aBoxHeader.getText());
        Assert.assertEquals("A", dragAndDropPage.bBoxHeader.getText());
    }
}

package StepDefinitions.dragAndDrop;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DragAndDropSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public DragAndDropSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on drag and drop page")
    public void the_user_clicks_on_drag_and_drop_page() {
       pageObject.dragAndDropPage().the_user_clicks_on_drag_and_drop_page();
    }
    @Then("the user should see the drag and drop page")
    public void the_user_should_see_the_drag_and_drop_page() {
        pageObject.dragAndDropPage().the_user_should_see_the_drag_and_drop_page();
    }
    @When("the user drag draggable item {string} into the item {string} on the drag and drop page")
    public void the_user_drag_draggable_item_into_the_item_on_the_drag_and_drop_page(String startPosition, String endPosition) {
        pageObject.dragAndDropPage().the_user_drag_draggable_item_into_the_item_on_the_drag_and_drop_page(startPosition,endPosition);
    }
    @Then("the user should see the item {string} into the item {string} on the drag and drop page")
    public void the_user_should_see_the_item_into_the_item_on_the_drag_and_drop_page(String startPosition, String endPosition) {
        pageObject.dragAndDropPage().the_user_should_see_the_item_into_the_item_on_the_drag_and_drop_page(startPosition, endPosition);
    }

}

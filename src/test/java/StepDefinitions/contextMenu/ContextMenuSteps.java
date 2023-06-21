package StepDefinitions.contextMenu;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ContextMenuSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public ContextMenuSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on context menu page")
    public void the_user_clicks_on_context_menu_page() {
        pageObject.contextMenuPage().the_user_clicks_on_context_menu_page();

    }
    @Then("the user should see the ContextMenu page")
    public void the_user_should_see_the_context_menu_page() {
        pageObject.contextMenuPage().the_user_should_see_the_context_menu_page();

    }

    @When("the user right-click in the dotted box in the ContextMenu page")
    public void the_user_right_click_in_the_dotted_box_in_the_context_menu_page() {
       pageObject.contextMenuPage().the_user_right_click_in_the_dotted_box_in_the_context_menu_page();
    }
    @Then("the user should see the context-menu in the ContextMenu page")
    public void the_user_should_see_the_context_menu_in_the_context_menu_page() {
        pageObject.contextMenuPage().the_user_should_see_the_context_menu_in_the_context_menu_page();
    }
}

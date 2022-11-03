package pageobjects;


import actions.ActionHelper;
import org.openqa.selenium.By;

public class DynamicLoadingPage extends CommonPage {

    private static DynamicLoadingPage _instance = null;
    private final By startButton = By.xpath("//button[text()='Start']");
    private final By header = By.cssSelector("div.example div:first-of-type h4");

    public static DynamicLoadingPage getInstance() {
        if (_instance == null)
            _instance = new DynamicLoadingPage();
        return _instance;
    }


    public void clickStartButton() {
        ActionHelper.click(startButton);
    }

    public String getHeaderText() {
        return ActionHelper.getText(header);
    }

}
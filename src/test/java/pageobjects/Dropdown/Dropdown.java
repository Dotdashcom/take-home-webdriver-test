package pageobjects.Dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

public class Dropdown {
    protected WebDriver driver;
    private static final long DEFAULT_PAUSE = 2000;

    @FindBy(id ="dropdown")
    public WebElement elDropDown;

    public Dropdown(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HashMap expOptions() {
        HashMap<Integer, String> expItems = new HashMap<>();

        Select s = new Select(elDropDown);
        List<WebElement> options = s.getOptions();

        for (int i=1; i<options.size(); i++) {
            expItems.put(i, options.get(i).getText());
        }

        return expItems;
    }

    public HashMap actOptions() throws InterruptedException {
        HashMap<Integer, String> items = new HashMap<>();

        Select s = new Select(elDropDown);
        List<WebElement> options = s.getOptions();

        for (int i=1; i<options.size(); i++) {
            s.selectByIndex(i);
            Thread.sleep(DEFAULT_PAUSE);
            items.put(i, options.get(i).getText());
        }

        return items;
    }

}

package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FloatingMenuPage extends Functions {

    @FindBy(xpath = "//div[@id='menu']//a[text()='News']")
    public WebElement startBtn;

    @FindBy(xpath = "//div[@id='menu']//li")
    public List<WebElement> menuButtons;


    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public FloatingMenuPage() {

        PageFactory.initElements(driver, this);

    }

    public boolean allMenuButtonsVisible() {

        for (WebElement btn : menuButtons) {
            if (!btn.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}

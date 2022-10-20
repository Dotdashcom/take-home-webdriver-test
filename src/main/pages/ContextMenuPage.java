package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {


        @FindBy(css = "#hot-spot")
        private WebElement hotSpotBox;

        public ContextMenuPage(WebDriver browser) {
            super(browser);
        }

        public void contextClickOnHotSpotBox() {
            Actions actions = new Actions(driver);
            actions.contextClick(hotSpotBox).build().perform();
        }

        public String getMessageFromAlert() {
            String message = driver.switchTo().alert().getText();
            acceptAlert();
            return message;
        }

        public void acceptAlert() {
            driver.switchTo().alert().accept();
        }
    }


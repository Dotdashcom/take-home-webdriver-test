package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    public class LoginPage extends BasePage {

        @FindBy(name = "username")
        private WebElement username;

        @FindBy(name = "password")
        private WebElement password;

        @FindBy(css = "button.radius")
        private WebElement loginButton;

        @FindBy(css = "div[class='flash success']")
        private WebElement successText;

        @FindBy(css = "div[class='flash error']")
        private WebElement failText;

        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public String successLogin(String username, String password) {
            login(username, password);

            return successText.getText();
        }

        public String failLogin(String username, String password) {
            login(username, password);

            return failText.getText();
        }

        private void login(String username, String password) {
            this.username.sendKeys(username);
            this.password.sendKeys(password);
            loginButton.click();
        }
    }

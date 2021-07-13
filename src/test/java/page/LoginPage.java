package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.Credential;

import java.util.LinkedList;
import java.util.List;

public class LoginPage extends PageObject {
    private final List<Credential> credentials = new LinkedList<>();

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]")
    private WebElement txtTitle;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement txtFlash;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/form[1]/button[1]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/a[1]")
    private WebElement btnLogout;

    public LoginPage(WebDriver driver) {
        super(driver);
        credentials.add(new Credential("tomsmith", "SuperSecretPassword!"));
        credentials.add(new Credential("tomsmith1", "SuperSecretPassword!"));
    }

    private void inputCredentials(Credential credential) {
        this.txtUsername.sendKeys(credential.getEmail());
        this.txtPassword.sendKeys(credential.getPassword());
    }

    public void inputValidCredentials() {
        Credential credential = this.credentials.get(0);
        this.inputCredentials(credential);
    }

    public void inputInvalidCredentials() {
        Credential credential = this.credentials.get(1);
        this.inputCredentials(credential);
    }

    public void performSubmitButtonClick() {
        this.btnSubmit.click();
    }

    public void performLogoutButtonClick() {
        this.btnLogout.click();
    }

    public String getTitleText() {
        return this.txtTitle.getText();
    }

    public String getFlashText() {
        return this.txtFlash.getText();
    }
}
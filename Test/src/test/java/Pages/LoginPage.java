package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement banner;

    public void enterUsername(String username){
        BrowserUtils.sendKeys(this.username,username);
    }

    public void enterPassword(String password){
        BrowserUtils.sendKeys(this.password,password);
    }

    public void pressLoginButton(){
        BrowserUtils.click(loginButton);
    }

    public String getBannerText(){
        String bannerText = BrowserUtils.getElementText(banner);
        return bannerText.substring(0,bannerText.length()-2);
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for login
    By inputUsername = By.id("username");
    By inputPassword = By.id("password");
    By btnLogin = By.xpath("//button[@type='submit']");
    By msgError = By.id("flash");

    //Method to login
    public void setUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
    public void loginPage(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.clickLogin();
    }

    public  boolean getTitle(String titleText){
        String title = driver.findElement(msgError).getText();
        boolean findText = title.contains(titleText);
        return findText;
    }
}

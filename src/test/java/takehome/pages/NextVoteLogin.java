package takehome.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class NextVoteLogin {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    @FindBy(id = "txtUserName")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private  WebElement password;

    @FindBy(css = "button#btnLogin > div")
    private WebElement loginBtn;
    @FindBy(id = "btnChenango")
    private WebElement chenangoBtn;
    @FindBy(id = "txtLastName")
    private WebElement lastNameField;
    @FindBy(id = "txtFirstName")
    private WebElement firstNameField;
    @FindBy(css = "button#btnSearch > div")
    private WebElement searBtn;
    @FindBy(css = "tr:nth-of-type(1) > td:nth-of-type(2) > span:nth-of-type(2) > .ng-star-inserted")
    private WebElement fName;
    @FindBy(css = "tr:nth-of-type(1) > td:nth-of-type(4) > span:nth-of-type(2) > .ng-star-inserted")
    private WebElement lName;



    public  void login(String usrName, String pass){
        username.sendKeys(usrName);
        password.sendKeys(pass, Keys.ENTER);

    }
    public void fillFullName(String firstName, String lastName){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(searBtn)).click();
    }
    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(chenangoBtn)).click();

    }

    public String getFirstNameText(){
        wait.until(ExpectedConditions.visibilityOf(fName));

        return fName.getText();
    }
    public String getLastNameTxt(){
        wait.until(ExpectedConditions.visibilityOf(lName));

        return lName.getText();
    }


    public NextVoteLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

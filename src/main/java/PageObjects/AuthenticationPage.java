package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class AuthenticationPage extends SeleniumLibrary
{
    //Creating Constructor
    public AuthenticationPage(WebDriver driver)  {
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.ID , using = "username")
    WebElement userNameTextBox;

    @FindBy(how = How.ID ,  using = "password" )
    WebElement passwordTextBox;

    @FindBy(how = How.XPATH , using = "(//i[@class='fa fa-2x fa-sign-in'])[1]")
    WebElement loginButton;

    @FindBy(how = How.XPATH , using = "(//i[@class='icon-2x icon-signout'])[1]")
    WebElement logoutButton;


    public boolean login(String userName, String password)
    {
        //Log.info(" *********** Started Login Functionality ***************** ");
        enterTextIntoTextBox(userNameTextBox, userName);
        enterTextIntoTextBox(passwordTextBox, password);
        clickOnElement(loginButton);
       return isElementDisplayed(logoutButton);

    }


}

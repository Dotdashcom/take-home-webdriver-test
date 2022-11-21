package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.setWrapper;

import static org.junit.Assert.assertTrue;

public class Login_Page extends setWrapper {
    protected String userName_Text="tomsmith";
    protected String RightPassword_Text="SuperSecretPassword!";
    protected String WrongPwd_Text="WrongPassword!";
    protected String AssertloginSucess_Text="You logged into a secure area!\n" +
            "×";
    protected String AssertloginFailed_Text="Your password is invalid!\n" +
            "×";
    By MessageAfterLogin_IdLoc=By.id("flash");
    By userName_Loc= By.id("username");
    By pssword_Loc= By.id("password");
    By loginBtn_loc =By.xpath("//*[@id=\"login\"]/button/i");
    public Login_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }
    public void waitForElement () {
        waitFor(10, userName_Loc);

    }
    public void sendUserName () {
        sendKeys(userName_Loc,userName_Text);
    }
    public void sendPassword () {
        sendKeys(pssword_Loc,RightPassword_Text);
    }
    public void sendWrongPassword () {
        sendKeys(pssword_Loc,WrongPwd_Text);
    }
    public void clickLoginBtn () {
        clickonButton(loginBtn_loc);

    }

    public void assertLogin (){
        waitFor(10,MessageAfterLogin_IdLoc);
        System.out.println(getTextFromLocator(MessageAfterLogin_IdLoc));
        //assertTrue(getTextFromLocator(MessageAfterLogin_IdLoc).contains(AssertloginSucess_Text));
        myassertValidation(AssertloginSucess_Text,getTextFromLocator(MessageAfterLogin_IdLoc),1);
    }
    public void assertWrongLogin (){
        waitFor(10,MessageAfterLogin_IdLoc);
        System.out.println(getTextFromLocator(MessageAfterLogin_IdLoc));
        //assertTrue(getTextFromLocator(MessageAfterLogin_IdLoc).contains(AssertloginSucess_Text));
        myassertValidation(AssertloginFailed_Text,getTextFromLocator(MessageAfterLogin_IdLoc),1);
    }

}

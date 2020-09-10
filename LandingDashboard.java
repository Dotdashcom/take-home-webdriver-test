package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_scripts.DriverWrapper;

public class LandingDashboard extends BasePage {
    //locators
    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By LoginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    private By checkBox2 = By.xpath("//input//parent::form//input[2]");
    private By checkBox1 = By.xpath("//input//parent::form//input[1]");
    private By contextMenuItem = By.xpath("//div[@id='hot-spot']");
    private By DropDownMenu = By.xpath("//select[@id='dropdown']");
    private By removeButton = By.xpath("//button[contains(text(),'Remove')]");
    private By enableButton = By.xpath("//button[contains(text(),'Enable')]");
    private By startButton = By.xpath("//button[text()='Start']");
    private By downloadLink = By.xpath("//a[text()='some-file.txt']");
    private By uploadLink = By.xpath("//input[@id=\"file-upload\"]");
    private By uploadButton = By.xpath("//input[@value='Upload']");
    private By viewProfileLink = By.partialLinkText("profile");
    private By JSAlert = By.xpath("//button[contains(text(),'Alert')]");
    private By notificationButton = By.linkText("Click here");
    private By clickHereButton = By.partialLinkText("Click");
    //methods
    public void enterUsername(String userName){
        setValue(usernameField,userName);
    }

    public void enterPassword(String passWord){
        setValue(passwordField,passWord);
    }

    public void clickLogin(){
        clickOn(LoginButton);
    }

    public void clickCheckBox2(){
        clickOn(checkBox2);
    }

    public void clickCheckBox1(){
        clickOn(checkBox1);
    }

    public void rightClickContextMenuItem(){
        rightClick(contextMenuItem);
    }

    public void selectOptionFromDropDown(String option){
        selectFromDropdown(DropDownMenu,option);
    }
    public void clickRemoveButton(){
        clickOn(removeButton);
    }

    public void clickEnableButton(){
        clickOn(enableButton);
    }

    public By getRemoveButton() {
        return removeButton;
    }
    public By getEnableButton(){
        return enableButton;
    }

    public void clickStartButton(){
        clickOn(startButton);
    }

    public void clickDownloadLink(){
        clickOn(downloadLink);
    }

    public void uploadFile(String file){
        setValue(uploadLink,file);
    }

    public void clickUpload(){
        clickOn(uploadButton);
    }

    public void clickOnProfileLink(){
        clickOn(viewProfileLink);
    }

    public void clickJSAlert(){
        clickOn(JSAlert);
    }

    public void clickNotificationMessage(){
        clickOn(notificationButton);
    }

    public void clickNewWindow(){
        clickOn(clickHereButton);
    }


    
}

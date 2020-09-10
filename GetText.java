package page_objects;
import org.openqa.selenium.By;

public class GetText extends BasePage {
    //this page is to capture error messages and/or success messages to verify the test cases

    private By loginSuccess = By.xpath("//h4[contains(text(),\"Welcome to the Secure\")]");
    private By loginFail = By.xpath("//div[@class='flash error']");
    private By checkBox2 = By.xpath("//input//parent::form//input[2]");
    private By checkBox1 = By.xpath("//input//parent::form//input[1]");
    private By dynamicElement = By.xpath("//div[@class='large-10 columns']//parent::div//parent::div[@id='content']/div[3]");
    private By text1 = By.xpath("//form[@id='checkbox-example']/p");
    private By text2 = By.xpath("//form[@id='input-example']/p");
    private By helloWorldText = By.xpath("//h4[text()='Hello World!']");
    private By fileUploadedMessage = By.xpath("//h3[text()='File Uploaded!']");
    private By iFrameBox = By.xpath("//p[contains(text(),'content')]");
    private By Sinatra = By.xpath("//h2[contains(text(),'Sinatra')]");
    private By successAlertMessage = By.id("result");
    private By JSerror = By.xpath("//p[contains(text(),'page')]");
    private By notificationMessage = By.xpath("//h3[text()='Notification Message']");
    private By newWindow = By.xpath("//h3[text()='New Window']");
    private By option1 = By.xpath("//select//option[@value=1]");



    //methods
    public String getLoginSuccessMessage() {
        return getValueFromElement(loginSuccess);
    }

    public String getLoginFailMessage() {
        return getValueFromElement(loginFail);
    }

    public boolean isCheckBox1Selected() {
        return isElementSelected(checkBox1);
    }

    public boolean isCheckBox2Selected() {
        return isElementSelected(checkBox2);
    }

    public String getTextFromDynamicElement() {
        return getValueFromElement(dynamicElement);
    }

    public String getMessagefromText1() {
        return getValueFromElement(text1);
    }

    public String getMessagefromText2() {
        return getValueFromElement(text2);
    }

    public By getText1() {
        return text1;
    }

    public By getText2() {
        return text2;
    }

    public By getHelloWorldText() {
        return helloWorldText;
    }

    public String getHelloWorldMessage() {
        return getValueFromElement(helloWorldText);
    }

    public String getUploadConfirmation() {
        return getValueFromElement(fileUploadedMessage);
    }

    public String getiFrameText() {
        return getValueFromElement(iFrameBox);
    }

    public String getSinatraMessage() {
        return getValueFromElement(Sinatra);
    }

    public String getSucessAlertMessage() {
        return getValueFromElement(successAlertMessage);

    }

    public String getJSerrorMessage() {
        return getValueFromElement(JSerror);
    }

    public String getNotificationSuccessMessage() {
        return getValueFromElement(notificationMessage);
    }

    public String getNewWindowMessage(){
        return getValueFromElement(newWindow);
    }

    public boolean isOptionOneSelected(){
        return isElementSelected(option1);
    }
}


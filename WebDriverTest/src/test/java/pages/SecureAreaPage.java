package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends Functions {

    @FindBy(xpath="//i[contains(@class,'ico')]//parent::h2")
    public WebElement secureAreaHeader;

    @FindBy(xpath="//div[@id='flash']")
    public WebElement message;


    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public SecureAreaPage(){

        PageFactory.initElements(driver, this);

    }

    /**
     * Method retrieves text from message
     * @param message
     * @return String
     */
    public String getMessage(WebElement message){
       return message.getText().replace("×","").trim();

    }
}

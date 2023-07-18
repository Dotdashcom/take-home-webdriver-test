package pageObject;

import base.CommonApi;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends CommonApi {
    WebDriver driver;
    public FileUploadPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id='file-upload']")
    WebElement chooseFileButton;

    @FindBy(xpath = "//*[@id='file-submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@class='example']//child::h3")
    WebElement message;


    public void uploadTheFile(){
        String file="C:\\Users\\Julian\\Downloads\\some-file.txt";
        //chooseFileButton.click();
        chooseFileButton.sendKeys(file);
        submitButton.click();
    }
    public String getMessage(){
        waitForWebElementToAppear(message);
        String text=message.getText();
        return text;
    }


    public void goTo(){
        driver.get("http://localhost:7080/upload");
    }
}

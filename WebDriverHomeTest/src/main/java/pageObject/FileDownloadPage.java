package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage extends CommonApi {
    WebDriver driver;

    public FileDownloadPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']//child::a")
    WebElement fileLink;


    public void clickOnFile(){
        fileLink.click();

    }
    public boolean verifyTheFile(){
        File file=new File("C:\\Users\\Julian\\Downloads");
       return file.exists();

    }

    public void goTo(){
        driver.get("http://localhost:7080/download");
    }


}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage {

    @FindBy( how = How.CSS , using = "a[href='download/abc.jpg']")
    WebElement fileName;

    public FileDownloadPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void downloadFile(){
        fileName.click();
    }
}

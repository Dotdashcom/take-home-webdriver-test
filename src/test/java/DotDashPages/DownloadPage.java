package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DownloadPage {

    public WebDriver ldriver;

    public DownloadPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the text file
    @FindBy(xpath="//div[@class=\"example\"]/a")
    WebElement txtfile;


    //click on the text file to download
    public void clktxtfile()
    {
        txtfile.click();
    }

    //Function to check whether file exists in the path specified
    public static boolean isFileExists(String path)
    {
        File file = new File(path);
        if(file.exists())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}

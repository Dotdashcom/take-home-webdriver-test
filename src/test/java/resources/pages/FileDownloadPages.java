package resources.pages;

import java.io.File;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class FileDownloadPages extends BaseClass {

    public FileDownloadPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.example>a")
    WebElement filename;

    public void userfileDownload() {
        filename.click();
    }

    public boolean userverifyfiledownload() {
        String fname=filename.getText();
        String FileLocation=System.getProperty("user.dir")+"\\Downloads\\"+fname;
        System.out.println(FileLocation);
        File f = new File(FileLocation);
        return f.exists();
    }
}

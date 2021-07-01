package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

import java.io.File;


public class FileDownload {

    //local webdriver variable
    private WebDriver driver;


    @FindBy(xpath="//a[@href='download/some-file.txt']")
    private WebElement downloadLink;





    //Page Class Constructor
    public FileDownload(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void clickDownloadLink() {
        downloadLink.click();
    }

    public boolean isFileDownloaded(String downloadpath, String fileName) {

        boolean flag = false;

        File directory = new File(downloadpath);

        File[] content = directory.listFiles();

        for (int i = 0; i < (content != null ? content.length : 0); i++) {
            if (content[i].getName().contains(fileName))
                return flag=true;
        }
        return flag;
    }




    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/download");
    }
}

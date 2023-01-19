package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class FileDownloadingPage {
    public WebDriver driver;
    public Helpers helpers;

    public FileDownloadingPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By file_link = By.linkText("some-file.txt");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToFileDownloading() {

        driver.navigate().to(driver.getCurrentUrl() + "download");
    }


    public void Download_File() {
        helpers.Click(file_link);

    }

    public void AssertFileExists() {
        String download_dir_path = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads";
        File f = new File(download_dir_path);

        do {
            helpers.Wait(2);
        } while (!f.exists());

        String filename = f.list()[0];
        String complete_file_path = download_dir_path + "\\" + filename;
        helpers.Print(complete_file_path);
        File downloaded = new File(complete_file_path);
        Assert.assertTrue(f.exists());
        downloaded.delete();
    }


}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

import java.io.File;

public class DownLoad_Page extends setWrapper {
    By downloadFile_loc= By.xpath("//div/a[@href='download/some-file.txt']");
    public DownLoad_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome (){
        chromePreferencies();
        chromeOptions();
        chromeDriverSetUpOP();
    }
    public void setUrl(String RemainUrl){

        goToURL(UrlPref+RemainUrl);
    }

    public void downloadFile () throws InterruptedException {
    clickonButton(downloadFile_loc);
    Thread.sleep(8000);
    File file = new File(System.getProperty("user.dir")+"/some-file.txt");
    if (file.exists())System.out.println("File Successfully Downloaded");
    else System.out.println("File Not downloaded");
    }

}

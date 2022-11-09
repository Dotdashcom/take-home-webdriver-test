package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FileDownloadPage {

    private final By header = By.xpath("//h3[text()='File Downloader']");
    private final By fileName = By.xpath("//*[@id='content']/div/a[1]");

    public FileDownloadPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/download");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public boolean fileDownloadTest() throws IOException {
        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String filename = UtilitiesManager.FindElement(fileName).getText();
        UtilitiesManager.FindElement(fileName).click();
        File f = new File(tmpdir + filename);
        return f.exists();
    }

}

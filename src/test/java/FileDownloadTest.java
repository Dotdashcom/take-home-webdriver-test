import Pages.FileDownloadPage;
import Utils.Driver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class FileDownloadTest {

    FileDownloadPage file = new FileDownloadPage();
    private static String downloadPath = "D:\\some-file.txt";

    @Test
    public void Download() throws InterruptedException {

        ChromeOptions option = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.some-file.txt", false);
        option.setExperimentalOption("prefs", prefs);


        Driver.getDriver().get("http://localhost:7080/download");

        Driver.getDriver().manage().window().maximize();

        file.TextFile.click();

        Thread.sleep(15000);


        Driver.closeDriver();

    }
}
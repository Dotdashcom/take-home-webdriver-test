package Pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class FileDownloadPage extends PageBase {

    @FindBy(xpath = "//div[@class='example']/a")
    WebElement someFileText;

    public void downloadFileAndVerify() throws IOException {
        BrowserUtils.click(someFileText);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int fileNumb = BrowserUtils.getFileName();
        Assert.assertEquals(1, fileNumb);

    }

}

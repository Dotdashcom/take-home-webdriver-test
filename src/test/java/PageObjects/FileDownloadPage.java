package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Objects;

public class FileDownloadPage extends BasePage {

    @FindBy(linkText = "some-file.txt")
    private WebElement someFile;

    public WebElement downLoadFile() {
        return someFile;
    }

    @FindBy(xpath = "//a[.='some-file.txt']")
    public WebElement fileLink;

    public String directory = "/Users/omidahmadi";

    public boolean fileDownload(String fileName) throws InterruptedException {
        File dir = new File(directory);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

}

package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class DownloadPage {

    public SelenideElement linkDownloadFile = $(By.linkText("some-file.txt"));

    public void downloadFile() throws FileNotFoundException {
        /* https://selenide.org/2016/08/27/selenide-3.9.1/
         Selenide clicks on the element and waits (up to 4 seconds) until at least one file gets downloaded.
         If the file has not been downloaded, the test will be failed */
        linkDownloadFile.download();
    }

}

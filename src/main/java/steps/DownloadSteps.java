package steps;

import io.qameta.allure.Step;
import pages.DownloadPage;

import java.io.FileNotFoundException;

public class DownloadSteps {

    DownloadPage downloadPage = new DownloadPage();

    @Step("download some-file.txt file")
    public void checkDownloadFile() throws FileNotFoundException {
        downloadPage.downloadFile();
    }
}

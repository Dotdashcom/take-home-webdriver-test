package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileDownloadedPage;
import util.Driver;

public class FileDownload extends Driver {

    // file destination -> C:\Users\Jawal\IdeaProjects\dotdash\target\downloaded-files-from-tests
    FileDownloadedPage page = new FileDownloadedPage(Driver.getDriver());

    @Test
    public void file_download_test() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/download");

        page.fileLink.click();

        // adjust this wait depending on the amount of time it takes for the machine running the test to download the file
        Thread.sleep(1000);

        // need to use getText() method on the hyperlink and use the visible text to use in the assertion, since the visible text is the name of the file
        try {
            Assert.assertTrue(page.fileDownload("some-file.txt"), "file not found in " + page.directory);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

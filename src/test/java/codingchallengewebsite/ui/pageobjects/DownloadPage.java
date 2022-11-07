package codingchallengewebsite.ui.pageobjects;

import static codingchallengewebsite.ui.UITest.*;
import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Downloader']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='some-file.txt']")
    public WebElement downloadLink;
    private final UITest caller;
    private final String pageUrl;
    private final Path relativePathToReferenceFile = Paths.get("src/test/resources", "some-file.txt");

    public DownloadPage(UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/download";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public Boolean fileDownload() {
        String downloadHref = downloadLink.getAttribute("href");
        String downloadFileName = Paths.get(downloadHref).getFileName().toString();
        String tempFileName = downloadFileName.split("\\.")[0] + ".crdownload";
        Path pathToReferenceFile = Paths.get(relativePathToReferenceFile.toString());
        Path tempDownloadedFilePath = Paths.get(downloadsFolder, tempFileName);
        Path expectedDownloadedFilePath = Paths.get(downloadsFolder, downloadFileName);
        File expectedFile = new File(expectedDownloadedFilePath.toAbsolutePath().toString());
        File expectedTmpFile = new File(tempDownloadedFilePath.toAbsolutePath().toString());
        long bytes=-1, newBytes=0;

        // Case: There's no reference file to compare the file against to
        if (!pathToReferenceFile.toAbsolutePath().toFile().exists()) { return false; }

        // Case: The file to be downloaded or a .crdownload from it already exist in the download folder - delete it
        try { Files.deleteIfExists(expectedFile.toPath()); Files.deleteIfExists(expectedTmpFile.toPath()); }
        catch (IOException e) { System.out.println(e); }

        // Start downloading
        downloadLink.click();

        // Give it some buffer time...
        try { Thread.sleep(5000); } catch (InterruptedException e) { System.out.println(e); }

        // Case: The file is still downloading - keeping track of it's size until the download finishes
        while ((bytes != newBytes) && expectedTmpFile.exists() && !expectedFile.exists()) {
            try { newBytes = Files.size(tempDownloadedFilePath); } catch (IOException e) { System.out.println(e); }
            bytes = newBytes;
            // Check again in 1 sec...
            try { Thread.sleep(1000); } catch (InterruptedException e) { System.out.println(e); }
        }

        // Case: The file arrived
        if (expectedFile.exists()) {
            try {
                return compareByMemoryMappedFiles(expectedDownloadedFilePath.toAbsolutePath(), pathToReferenceFile.toAbsolutePath());
            } catch (IOException e) { System.out.println(e); }
        }

        // None of the above - download failed
        return false;
    }

    public static @NotNull Boolean compareByMemoryMappedFiles(Path path1, Path path2) throws IOException {
        try (RandomAccessFile randomAccessFile1 = new RandomAccessFile(path1.toFile(), "r");
             RandomAccessFile randomAccessFile2 = new RandomAccessFile(path2.toFile(), "r")) {

            FileChannel ch1 = randomAccessFile1.getChannel();
            FileChannel ch2 = randomAccessFile2.getChannel();
            if (ch1.size() != ch2.size()) {
                return false;
            }
            long size = ch1.size();
            MappedByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, size);
            MappedByteBuffer m2 = ch2.map(FileChannel.MapMode.READ_ONLY, 0L, size);

            return m1.equals(m2);
        }
    }
}
package codingchallengewebsite.ui.pageobjects;

import static codingchallengewebsite.ui.UITests.*;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class DownloadPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Downloader']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='some-file.txt']")
    private WebElement downloadLink;
    private final UITests caller;
    private final String pageUrl;
    public WebDriver driver;
    private final String relPathToExpectedFile = Paths.get("src/main/resources", "some-file.txt").toString();
    private String relPathToDownloadedFile;

    public DownloadPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/download").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("File Downloader");
    }

    public boolean startFileDownload() {
        String downloadHref = downloadLink.getAttribute("href").replace(":", "");
        String downloadFileName = Paths.get(downloadHref).getFileName().toString();
        Path downloadedFilePath = Paths.get(downloadsFolder, downloadFileName);
        Path expectedFilePath = Paths.get(relPathToExpectedFile).toAbsolutePath();

        // There's no file to compare against to
        if (!expectedFilePath.toAbsolutePath().toFile().exists()) { return false; }

        // Delete the file if it exists locally
        try {
            File file = new File(downloadedFilePath.toAbsolutePath().toString());
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Begin download; wait until download is complete
        downloadLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> {
            return (downloadedFilePath.toFile().exists() && downloadedFilePath.toFile().length() == expectedFilePath.toFile().length());
        });

        this.relPathToDownloadedFile = downloadedFilePath.toString();

        return true;
    }

    public boolean validateFileDownload() {
        File downloadedFile = new File(this.relPathToDownloadedFile);


        if (downloadedFile.exists()) {
            try {
                return compareByMemoryMappedFiles(Paths.get(this.relPathToDownloadedFile), Paths.get("src/main/resources/some-file.txt").toAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static boolean compareByMemoryMappedFiles(Path path1, Path path2) throws IOException {
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

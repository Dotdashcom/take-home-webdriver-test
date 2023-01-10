package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileDownloadPage extends BasePage {

    private static final String DOWNLOAD_ENDPOINT = "download";

    @FindBy(xpath = "//div//h3/following-sibling::a")
    private List<WebElement> downloadLinkList;

    @FindBy(xpath = "//div//h3/following-sibling::a[1]")
    private WebElement firstAvailableDownloadLink;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public FileDownloadPage getFileDownloadPage() {
        getDriver(DOWNLOAD_ENDPOINT);

        return this;
    }

    public String getFirstAvailableFileDownloadLink() {

        return firstAvailableDownloadLink.getAttribute("href");
    }

    public String getFirstAvailableFileName() {
        String[] urlArray = firstAvailableDownloadLink.getAttribute("href").split("/");

        return urlArray[urlArray.length - 1];
    }

    public List<String> getDownloadLinkList() {

        return downloadLinkList
                .stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toList());
    }

    public boolean isFileDownloaded() {
        String[] urlArray = firstAvailableDownloadLink.getAttribute("href").split("/");
        String fileName = urlArray[urlArray.length - 1];

        try {
            File fileLocation = new File(getDefaultDownloadFolder());

            return Arrays.stream(fileLocation.list()).anyMatch(element -> element.equals(fileName));
        } catch (NullPointerException e) {
            BaseUtils.log("Error when getting the file list");
            e.fillInStackTrace();

            return false;
        }
    }

    public boolean isFileAlreadyDownloadedInDefaultDownloadFolder() {
        File defaultDownloadFolder = new File(getDefaultDownloadFolder());
        try {
            if(Arrays.stream(
                    defaultDownloadFolder.list())
                    .anyMatch(element->element.equals(getFirstAvailableFileName()))
            ) {
                return true;
            } else {
                return false;
            }
        } catch(NullPointerException e) {
            BaseUtils.log("Error when getting the file list");
            e.fillInStackTrace();

            return false;
        }
    }

    public FileDownloadPage clickFirstAvailableDownloadLink() {
        if(isFileAlreadyDownloadedInDefaultDownloadFolder()) {
            try {
                File existingFile = new File(getDefaultDownloadFolder() + getFirstAvailableFileName());
                existingFile.delete();
            } catch (Exception e) {
                BaseUtils.log("Error when deleting the existing file");
                e.fillInStackTrace();
            }
        }

        firstAvailableDownloadLink.click();
        getWait(5).until(BaseUtils.ExpectedConditions.fileIsDownloaded(getDefaultDownloadFolder(), getFirstAvailableFileName()));

        return this;
    }
}
package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.utils.JavaUtils.isFileDownloaded;
import static com.assignments.enums.WaitStrategy.CLICKABLE;

public final class FileDownloadPage extends BasePage {

    private final By fileLink = By.cssSelector("a[href='download/some-file.txt']");

    public FileDownloadPage clickOnFileLink() {
        click(fileLink, CLICKABLE, "File Link");
        return this;
    }

    public boolean isFilePresent(String filePath) {
        return isFileDownloaded(filePath);
    }
}


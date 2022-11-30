package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.FileDownloadPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileDownloadTests extends BaseTest {
    static File file;

    @Test
    public void shouldDownloadFile() throws InterruptedException {
        FileDownloadPage fileDownloadPage = GeneratePage
                .fileDownloadPage()
                .goToFileDownloadPage()
                .clickDownloadFile();

        file = new File(Paths.get("src", "main", "resources", "some-file.txt").toString());

        assertThat(fileDownloadPage.isFileDownloaded(file), is(true));
    }

    @AfterMethod
    public void deleteDownloadedFile() {
        file.delete();
    }
}

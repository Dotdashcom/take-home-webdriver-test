package com.dotdash.scripts;

import com.dotdash.pages.DownloadFile;
import org.junit.Test;
import utils.DownloadedFile;

import static org.hamcrest.CoreMatchers.is;

public class DownloadFileTest extends BaseWebTest<DownloadFile> {

    @Test
    public void downloadFile() {
        DownloadFile downloadFilePage = getInitialPage();
        String filename = downloadFilePage.getDownloadFilename();
        DownloadedFile file = new DownloadedFile(filename);

        downloadFilePage.downloadFile();

        checkThat("File is downloaded", file.isPresent(), is(true));
    }
}

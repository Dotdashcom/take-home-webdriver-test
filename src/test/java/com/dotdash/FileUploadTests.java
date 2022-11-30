package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.FileUploadPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileUploadTests extends BaseTest {

    @Test
    public void shouldUploadFile() {
        String path = System.getProperty("user.dir") + File.separator + Paths.get("src", "main", "resources", "some-file-to-upload.txt").toString();
        FileUploadPage fileUploadPage = GeneratePage
                .fileUploadPage()
                .goToFileUploadPage()
                .uploadFile(path);

        assertThat(fileUploadPage.getUploadSuccessMessage(), is("some-file-to-upload.txt"));
    }
}

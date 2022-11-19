package com.dotdash.scripts;

import com.dotdash.pages.UploadFile;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UploadFileTest extends BaseWebTest<UploadFile> {

    @Test
    public void uploadFile() {
        UploadFile uploadFilePage = getInitialPage();

        String fileName = "testdata.txt";
        uploadFilePage.uploadFileWithButton(fileName).submitFile();

        checkThat("File upload success message is displayed", uploadFilePage.getSuccessMessage(), equalTo(fileName));
    }
}

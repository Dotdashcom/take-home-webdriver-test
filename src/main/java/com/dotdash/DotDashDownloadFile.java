package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashDownloadFile extends BaseAPI {

    public static String downloadPath = home + "/Downloads/";
    public static String fileName = "some-file.txt";


    @FindBy(how = How.LINK_TEXT, using = txtFileLT)
    public WebElement txtFile;

    // Page Factory
    static DotDashDownloadFile download;

    public static void initPage() {
        download = PageFactory.initElements(driver, DotDashDownloadFile.class);
    }

    public static void downloadFile() {
        initPage();
        click(download.txtFile);
    }

    // Check if the target file has been downloaded into the download path
    public static boolean isFileDownloaded(String fileName) {
        initPage();
        boolean flag = false;
        File dir = new File(download.downloadPath);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
    }

    public static void assertFileDownloaded() {
        Assert.assertTrue(isFileDownloaded(fileName), "Failed to download document");
    }

    public static void navigateToDownloadPage() {
        driver.get(baseURL + "download");
    }
}


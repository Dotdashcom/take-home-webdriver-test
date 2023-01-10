package tests;

import model.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import runner.BaseUtils;

public class FileDownloadTest extends BaseTest {
    
    @Test
    public void testDownloadFirstAvailableFile() {
        boolean actualResult = new FileDownloadPage(getDriver())
                .getFileDownloadPage()
                .clickFirstAvailableDownloadLink()
                .isFileDownloaded();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testIsFirstAvailableDownloadLinkBroken() {
        int responseCode = 0;
        String fileDownloadLink = new FileDownloadPage(getDriver())
                .getFileDownloadPage()
                .getFirstAvailableFileDownloadLink();
        System.out.println(fileDownloadLink);


        try {
            HttpURLConnection connection = (HttpURLConnection) (new URL(fileDownloadLink).openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            BaseUtils.log("Connection error");
        }

        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void testDownloadLinksHttpStatus() {
        List<Integer> responseCodeList = new ArrayList<>();

        List<String> fileDownloadLinkList = new FileDownloadPage(getDriver())
                .getFileDownloadPage()
                .getDownloadLinkList();
        for (String link : fileDownloadLinkList) {
            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(link).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCodeList.add(connection.getResponseCode());
            } catch (IOException e) {
                BaseUtils.log("Connection error");
            }
        }

        Assert.assertTrue(responseCodeList.stream().allMatch(element->element < 400) &&
                responseCodeList.size() !=0);
    }
}
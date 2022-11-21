package com.qa.pages;

import org.openqa.selenium.By;

import java.io.File;

public class FileDownLoad extends BasePage{

    By downloadLink= By.xpath("//*[text()='some-file.txt']");


    public Boolean isFileDownloaded(String fileName) {
        Utility.wait(driver.findElement(downloadLink));
        driver.findElement(downloadLink).click();
        boolean flag = false;
        String dirPath = System.getProperty("User.Home")+"//Download";
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present");
                    listFile.delete();
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }
}

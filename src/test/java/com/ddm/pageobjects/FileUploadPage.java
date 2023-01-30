package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;

public class FileUploadPage extends WebPage {

    @FindBy(css = "#file-upload")
    WebElement chooseFileInput;

    @FindBy(css = "#file-submit")
    WebElement uploadButton;

    public FileUploadPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void uploadSampleFile() {
        String filePath = generateSampleFileToUpload();
        chooseFileInput.sendKeys(filePath);
        uploadButton.click();
    }

    public boolean isUploadSuccess() {
        if(isElementPresentCss("#uploaded-files")) {
            return true;
        }
        return false;
    }

    private String generateSampleFileToUpload() {
        String pathSeparator = "";
        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            pathSeparator = "\\";
        } else if(System.getProperty("os.name").toLowerCase().contains("mac")) {
            pathSeparator = "/";
        }

        String downloadsDir = System.getProperty("user.home") + pathSeparator + "Downloads" + pathSeparator;
        String uploadingFileName = "FileToUpload.txt";
        String fileAbsPath = downloadsDir + uploadingFileName;
        System.out.println("Path : " + fileAbsPath);
        File file = new File(fileAbsPath);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File creation faild.");
            }
        }
        try {
            FileWriter fWriter = new FileWriter(file);
            fWriter.write("Some text in the file.");
            fWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAbsPath;
    }

}
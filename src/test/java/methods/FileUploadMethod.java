package methods;

import model.FileUploadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadMethod extends GeneralTestMethod{

    private final String fileUploadURL = "http://localhost:7080/upload";
    FileUploadPage fileUploadPage;
    public void startFileUploadTest(String fileName) throws InterruptedException {
        driver.get(fileUploadURL);
        fileUploadPage = new FileUploadPage(driver);
        uploadFile(fileName);

    }

    public void uploadFile(String fileName) throws InterruptedException {
        WebElement chooseFile = fileUploadPage.chooseFileComponent();
        WebElement uploadButton = fileUploadPage.uploadComponent();

        chooseFile.sendKeys(fileName);
        Thread.sleep(1000);
        uploadButton.click();
        Thread.sleep(1000);
    }

    public boolean isUploadSuccess() {
        return (driver.findElements(By.id("uploaded-files")).size() > 0);
    }

}

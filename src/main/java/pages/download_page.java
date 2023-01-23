package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

import java.io.File;
import java.io.IOException;

public class download_page extends Base_Page {
    WebDriver driver;

    public download_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/a")
    WebElement clicks_on_the_file;
    public void File_Download_meth() throws IOException, InterruptedException {
        clicks_on_the_file.click();

        String path = "C:\\Users\\ADMIN\\Downloads";
        File file = new File(path);
        Thread.sleep(3000);
        Boolean file_to_download = file.exists();
        Assert.assertTrue(file_to_download, "File not downloaded");

    }
}

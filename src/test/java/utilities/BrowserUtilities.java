package utilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class BrowserUtilities {

    protected Duration time = Duration.ofSeconds(30);
    public Select select;

    protected String downloadPath = System.getProperty("user.dir") + "\\downloads";
    public String uploadPath = System.getProperty("user.dir") + "\\downloads\\";

    public void wait(int seconds){
        try{
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public boolean isFileDownloaded(String fileName) {
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName))
                    file.deleteOnExit();
                return true;
            }
        }
        return false;
    }

    public void deleteFiles() {
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                file.deleteOnExit();
            }
        }
    }
}


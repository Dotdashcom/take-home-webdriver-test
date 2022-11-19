package utils;

import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.io.File;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static properties.TestProperties.TEST_PROPERTIES;

public class DownloadedFile implements Logging {

    private final String fileName;

    public DownloadedFile(String fileName) {
        this.fileName = fileName;
    }

    public boolean isPresent() {
        File file = getFile();
        return new MyFluentWait().waitFor(new FileExistsCondition(file)).isPresent();
    }

    private File getFile() {
        String downloadsDir = LocalEnvironment.getDownloadsPath();
        return new File(downloadsDir.isEmpty() ? fileName : downloadsDir + File.separator + fileName);
    }

    private static class FileExistsCondition implements ExpectedCondition<Boolean> {

        private final File file;

        FileExistsCondition(File file) {
            this.file = file;
        }

        @Nullable
        @Override
        public Boolean apply(@Nullable WebDriver x) {
            return file != null && file.exists();
        }

        @Override
        public String toString() {
            return "downloaded file to be present in disk";
        }
    }
}

import org.benjamin.pages.FileDownload;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileDownloadTest extends FileDownload {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void fileDownload_download_success() {
        clickDownload();
        Assertions.assertTrue(isExist());
    }
}

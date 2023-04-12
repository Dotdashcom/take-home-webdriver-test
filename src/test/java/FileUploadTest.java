import org.benjamin.pages.FileUpload;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileUploadTest extends FileUpload {
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
        clickUpload();
        Assertions.assertTrue(isUploaded());
    }
}

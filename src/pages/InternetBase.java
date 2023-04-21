import org.openqa.selenium.WebDriver;

public class InternetBase {
    private static WebDriver driver;

    private String baseUrl = "http://localhost:7080";

    public String getBaseUrl() {
        return baseUrl;
    }
}

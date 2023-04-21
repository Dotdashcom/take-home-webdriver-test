import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InternetSecurePage {
    private static WebDriver driver;

    private String path = "/secure";
    private By logoutButtonBy = By.xpath("//a[contains(@class,\"button\")]/i[contains(text(),\"Logout\")]");
    private By alertMessageBy = By.xpath("//div[@id='flash']");

    InternetSecurePage(WebDriver webdriver) {
        driver = webdriver;
    }
    public String getUrl() {
        InternetBase internetBase = new InternetBase();
        String url = internetBase.getBaseUrl() + path;
        return url;
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButtonBy).click();
    }

    public String getAlertMessage() {
        String msg = driver.findElement(alertMessageBy).getText();
        System.out.println(msg);
        return msg;
    }
}

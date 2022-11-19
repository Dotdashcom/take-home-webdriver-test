package Main.Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage {
    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) { this.driver = driver; }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:7080/checkboxes");
    }

private By checkbox1 = By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]");
private By checkbox2 = By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]");

    }


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class javascript_alerts_page extends Base_Page {

    WebDriver driver;

    public javascript_alerts_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/ul/li[1]/button")
    WebElement js_alert_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/ul/li[2]/button")
    WebElement js_confirm_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/ul/li[3]/button")
    WebElement js_prompt_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"result\"]")
    WebElement result;

    public void JavaScript_Alerts_meth() {

        js_alert_button.click();
        String js_alert = driver.switchTo().alert().getText();
        String expected_alert = "I am a JS Alert";
        check_String(js_alert,expected_alert, "wrong message");
        driver.switchTo().alert().accept();
        String result_alert_1  = result.getText();
        String result_alert_1_expected = "You successfuly clicked an alert";
        check_String(result_alert_1, result_alert_1_expected, "wrong alert");

        js_confirm_button.click();
        String js_confirm = driver.switchTo().alert().getText();
        String expected_confirm = "I am a JS Confirm";
        check_String(js_confirm,expected_confirm, "wrong message");
        driver.switchTo().alert().accept();
        String result_confirm  = result.getText();
        String resdult_confirm_expected = "You clicked: Ok";
        check_String(result_confirm, resdult_confirm_expected, "wrong alert");

        js_prompt_button.click();
        String js_prompt = driver.switchTo().alert().getText();
        String expected_prompt = "I am a JS prompt";
        check_String(js_prompt, expected_prompt, "wrong message");
        String to_prompt = "Hi there";
        driver.switchTo().alert().sendKeys(to_prompt);
        driver.switchTo().alert().accept();
        String result_prompt  = result.getText();
        String result_prompt_expected = "You entered: "+to_prompt;
        check_String(result_prompt,result_prompt_expected, "wrong alert");

    }
}

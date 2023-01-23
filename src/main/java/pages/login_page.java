package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

import java.util.HashSet;
import java.util.Set;

public class login_page extends Base_Page {

    WebDriver driver;
    String str;

    public login_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
    WebElement user_name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
    WebElement pass_word;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/button/i")
    WebElement click_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/a/i")
    WebElement log_out;
    @FindBy(how = How.XPATH, using = "//*[@id=\"flash\"]")
    WebElement actual_message;


    public void login_meth(String un, String pw) {
        String[] a = { un, un + x };
        String[] b = { pw, pw + x };
        Set<String> set = new HashSet<String>();
        for (String st1 : a) {
            for (String st2 : b) {
                set.add(st1 + " " + st2);
                user_name.clear();
                user_name.sendKeys(st1);
                pass_word.clear();
                pass_word.sendKeys(st2);
                click_button.click();
                str = actual_message.getText();

                if (st1.equals(un) && st2.equals(pw)) {
                    if (str.contains("You logged into a secure area!")) {
                        System.out.println(str + " username is: " + st1 + " ,password is: " + st2);
                        log_out.click();
                        Assert.assertTrue(true);
                    } else
                        Assert.assertTrue(false);
                } else if (st1.equals(un) && !st2.equals(pw)) {
                    if (str.contains("Your password is invalid!")) {
                        System.out.println(str + " username is: " + st1 + " ,password is: " + st2);
                        Assert.assertTrue(true);
                    } else
                        Assert.assertTrue(false);
                } else if (!st1.equals(un) && st2.equals(pw)) {
                    if (str.contains("Your username is invalid!")) {
                        System.out.println(str + " username is: " + st1 + " ,password is: " + st2);
                        Assert.assertTrue(true);
                    } else
                        Assert.assertTrue(false);
                } else if (!st1.equals(un) && !st2.equals(pw)) {
                    if (str.contains("Your username is invalid!")) {
                        System.out.println(str + " username is: " + st1 + " ,password is: " + st2);
                        Assert.assertTrue(true);
                    } else
                        Assert.assertTrue(false);
                }
            }
        }

    }
}
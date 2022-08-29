package pages;

import org.openqa.selenium.By;


public class LoginPage {

    public static By userNameTextBox = By.xpath("//form[contains(@name,'login')]/descendant::label[text()='Username']/following::input[1]");
    public static By passwordTextBox = By.xpath("//form[contains(@name,'login')]/descendant::label[text()='Password']/following::input[1]");
    public static By loginButton = By.xpath("//form[contains(@name,'login')]/descendant::i[contains(text(),'Login')]/ancestor::button");
    public static By loginErrorLabel = By.xpath("//div[contains(@class,'flash error')]");

    }




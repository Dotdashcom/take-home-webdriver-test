package pages;

import org.openqa.selenium.By;

/**
 * LoginPage.java
 *
 * Page object for login web form located at 'http://localhost:7080/login'
 *
 * NOTE: Using LEAN page object model approach where only locators for element in page object are stored.
 * (In a larger framework, I would put the methods that are normally here in separate Java classes built
 * out to represent typically elements (e.g. Button, Label, Link, Textbox). Each of these would have methods
 * that make sense for that element and take the locators from here as parameters)
 */
public class LoginPage {

    public static By userNameTextBox = By.xpath("//form[contains(@name,'login')]/descendant::label[text()='Username']/following::input[1]");
    public static By passwordTextBox = By.xpath("//form[contains(@name,'login')]/descendant::label[text()='Password']/following::input[1]");
    public static By loginButton = By.xpath("//form[contains(@name,'login')]/descendant::i[contains(text(),'Login')]/ancestor::button");
    public static By loginErrorLabel = By.xpath("//div[contains(@class,'flash error')]");
}

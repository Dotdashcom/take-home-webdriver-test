package Helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Helpers {
    private static WebDriver driver;
    private static Faker faker;
    WebDriverWait wait;
    Actions actions;
    private int seconds = 20;
    public Helpers(){
    }
    public Helpers(WebDriver driver){
        this.driver = driver;
        this.faker = new Faker();
        this.wait = new WebDriverWait(driver,seconds);
    }

    public void getURL(String url) {
        Print("Se ingresa a la URL:" + url);
        driver.get(url);
    }
    public String getXMLParameter(String Key) {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(Key);
    }
    public Boolean isDisabled(By by) {
       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        if(element.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

    public void Wait(int secs){
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void Print(String texto){
        System.out.println(texto + "\r\n");
    }

    public void Click(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        // ----------------------------------------------------

        WebElement elemento = driver.findElement(by);

        // ----------------------------------------------------

        elemento.click();
        Print("Se realiza Click a Elemento:" + by);
    }
    public void SelectByValue(By by, String value) {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        // ----------------------------------------------------
       Select dropdown = new Select(driver.findElement(by));
        // ----------------------------------------------------
        dropdown.selectByValue(value);

    }
    public String GetTextSelect(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        // ----------------------------------------------------
        Select dropdown = new Select(driver.findElement(by));

        WebElement o = dropdown.getFirstSelectedOption();
        String selectedoption = o.getText();
        // ----------------------------------------------------
        return selectedoption;

    }

    public void RightClick(By by) {
        // Espera dinamica
        wait.until(ExpectedConditions.elementToBeClickable(by));
        // ----------------------------------------------------
        actions = new Actions(driver);

        WebElement elementLocator = driver.findElement(by);

        actions.contextClick(elementLocator).perform();

        Print("Se realiza Right Click a Elemento:" + by);
    }

    public void ClickJS(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void sendText(By by, String text) {
        WebElement elemento =  wait.until(ExpectedConditions.elementToBeClickable(by));
        elemento.sendKeys(text);
        Print("Se envia texto "+ text +" a Elemento:"+ by);
    }
    public boolean compare_text(String origin, String subject){
        return origin.equals(subject);
    }
    public boolean contains_text(String origin, String subject){
        Print("Se compara Origen: " + origin + " con Objetivo: " + subject);
        return origin.contains(subject);
    }
    public String getText(By by){
        WebElement elemento =  wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String texto_extraido = elemento.getText();
        Print("Se extrae texto: "+ texto_extraido+ " del elemento: " +by );
        return texto_extraido;
    }
    public String getAttribute(By by, String attribute){
        WebElement elemento =  wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String texto_extraido = elemento.getAttribute(attribute );
        Print("Se extrae texto: "+ texto_extraido+ " del elemento: " +by );
        return texto_extraido;
    }
    public String getText(WebElement elemento){
        String texto_extraido = elemento.getText();
        Print("Se extrae texto: "+ texto_extraido+ " del elemento: " + elemento );
        return texto_extraido;
    }
    // ---------------FAKER METHODS-------------------------------------
    public String fake_first_name(){
        return faker.name().firstName();
    }
    public String fake_email_address(){
        return faker.internet().emailAddress();
    }
    public String fake_address(){
        return faker.address().streetAddress();
    }

    // ---------------FAKER METHODS-------------------------------------


    public void DragNDrop(By from, By to) {

        wait.until(ExpectedConditions.elementToBeClickable(from));
        wait.until(ExpectedConditions.elementToBeClickable(to));
        // ----------------------------------------------------
        actions = new Actions(driver);

        WebElement elementLocatorFrom = driver.findElement(from);
        WebElement elementLocatorTo   = driver.findElement(to);

        actions.dragAndDrop(elementLocatorFrom,elementLocatorTo);
        actions.build().perform();


        actions.clickAndHold(elementLocatorFrom).moveToElement(elementLocatorTo).click(elementLocatorTo).release().build().perform();
        actions.clickAndHold(elementLocatorFrom).build().perform();
        Wait(5);
        actions.click(elementLocatorTo).build().perform();
        actions.release(elementLocatorTo).build().perform();
        actions.clickAndHold(elementLocatorFrom).release(elementLocatorTo).build().perform();
    }
    public void DragNDrop2(By from, By to){
        // Using Action class for drag and drop.
        Actions act = new Actions(driver);
        WebElement elementLocatorFrom = driver.findElement(from);
        WebElement elementLocatorTo   = driver.findElement(to);
        // drag and drop.
        act.clickAndHold(elementLocatorFrom).build().perform();
        Wait(1);
        act.moveToElement(elementLocatorTo).build().perform();
        Wait(1);
        act.moveByOffset(-1, -1).build().perform();
        Wait(1);
        act.release().build().perform();
    }
}

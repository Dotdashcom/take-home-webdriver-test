package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utils.Utility.*;


public class Other {

    WebDriver driver;

    public Other(WebDriver driver) {
        this.driver=driver;
    }
    By checkOne = By.xpath("//input[@type='checkbox'][1]");
    By checkTwo = By.xpath("//input[@type='checkbox'][2]");
    By clickHere = By.xpath("//a[@href='/notification_message']");
    By msg = By.id("flash");
    By box = By.id("hot-spot");
    By dragA = By.id("column-a");
    By dragB = By.id("column-b");
    By option = By.id("dropdown");
    By dinamicContent1 = By.xpath("//*[@id=\"content\"]/div[1]/div[2]");
    By dinamicContent2 = By.xpath("//*[@id=\"content\"]/div[2]/div[2]");
    By dinamicContent3 = By.xpath("//*[@id=\"content\"]/div[3]/div[2]");
    By click_Here = By.xpath("//a[@href='/dynamic_content?with_content=static']");
    By btnStart = By.xpath("//*[@id=\"start\"]/button");
    By h4Text = By.xpath("//*[@id=\"finish\"]/h4");
    By btnRemove = By.xpath("//button[@type='button' and contains(., 'Remove')]");
    By checkA = By.xpath("//*[@id=\"checkbox\"]/input");
    By btnAdd = By.xpath("//button[@type='button' and contains(., 'Add')]");
    By btnEnable = By.xpath("//*[@type='button' and contains(., 'Enable')]");
    By inputEnable = By.xpath("//*[@id=\"input-example\"]/input");
    By btnDisable = By.xpath("//*[@type='button' and contains(., 'Disable')]");
    By someFile = By.xpath("//*[@id=\"content\"]/div/a");
    By textUpload = By.xpath("//*[@id=\"content\"]/div/h3");
    By btnUpload = By.xpath("//*[@id=\"file-submit\"]");
    By iframe = By.id("mce_0_ifr");
    By inputText = By.xpath("//*[@id=\"tinymce\"]/p");
    By menu = By.id("menu");


    public boolean scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));
        js.executeScript("arguments[0].scrollIntoView();", footer);
        boolean element = visibilityOfElementWait(driver,menu );
        if(element){
            return true;
        }else {
            return false;
        }
    }

    public boolean switchIframe(String texto){
        driver.switchTo().frame(0);
        boolean element = visibilityOfElementWait(driver,inputText );
        if(element){
            driver.findElement(inputText).sendKeys(texto);
            return true;
        }else {
            return false;
        }
    }

    public boolean uploadFile(){
        WebElement btn = driver.findElement(By.xpath("//input[@type='file']"));
        btn.sendKeys(System.getProperty("user.dir").concat("/src/test/resources/test-upload.txt"));
        esperar();
        driver.findElement(btnUpload).click();
        boolean element = clickableOfElementWait( driver,textUpload);
        if(element){
            return true;
        }else{
            return false;
        }

    }

    public void downloadFile() {
        driver.findElement(someFile).click();
        esperar();
    }

    public boolean clickDisable(){
        driver.findElement(btnDisable).click();
        boolean element = clickableOfElementWait( driver,inputEnable);
        if(!element){
            return true;
        }else{
            return false;
        }
    }

    public boolean clickEnable(){
        driver.findElement(btnEnable).click();
        boolean element = clickableOfElementWait( driver,inputEnable);
        if(element){
            driver.findElement(inputEnable).sendKeys("test");
            return true;
        }else{
            return false;
        }
    }

    public boolean clickAdd(){
        boolean element = visibilityOfElementWait( driver,btnAdd);
        if(element){
            driver.findElement(btnAdd).click();
            visibilityOfElementWait( driver,checkA);
            return true;
        }else{
            return false;
        }
    }

    public boolean clickRemove(){
        driver.findElement(btnRemove).click();
        boolean element = visibilityOfElementWait( driver,checkA);
        if(!element){
            return true;
        }else{
            return false;
        }
    }

    public String clickStart(){
        driver.findElement(btnStart).click();
        boolean element = visibilityOfElementWait( driver,h4Text);
        String texto="";
        if (element){
            texto = driver.findElement(h4Text).getText();
        }
        return texto;
    }

    public void click_Here(){
        driver.navigate().to(driver.getCurrentUrl());
        driver.findElement(click_Here).click();

    }
    public String getDinamicContentOne(){
        return driver.findElement(dinamicContent1).getText();
    }

    public String getDinamicContentTwo(){
        return driver.findElement(dinamicContent2).getText();
    }

    public String getDinamicContentThree(){
        return driver.findElement(dinamicContent3).getText();
    }

    public boolean select(int indice){
        try {
            Select select = new Select(driver.findElement(By.id("dropdown")));
            select.selectByIndex(indice);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public String moveAtoB(){
        Actions act = new Actions(driver);
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        act.dragAndDrop(columnA, columnB).perform();
        String text = driver.findElement(dragA).getText();
        return text;
    }
    public String moveBtoA(){
        Actions act=new Actions(driver);
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        act.dragAndDrop(columnB, columnA).build().perform();
        String text = driver.findElement(dragB).getText();
        return text;
    }

    public boolean rigthClickBox(){
        Actions action = new Actions(driver);
        //driver.findElement(box).
        WebElement box =driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if(wait.until(ExpectedConditions.alertIsPresent())==null) {
            return false;
        }else{
            System.out.println("Alert exists");
            return true;
        }
    }

    public  boolean getTitle(String titleText){
        String title = driver.findElement(msg).getText();
        boolean findText = title.contains(titleText);
        return findText;
    }

    public void clickHere(){
        driver.findElement(clickHere).click();
    }
    public void setCheckOne(){
        driver.findElement(checkOne).click();
    }
    public boolean getStateCheckOne(){
        return driver.findElement(checkOne).isSelected();
    }
    public void setCheckTwo(){
        driver.findElement(checkTwo).click();
    }
    public boolean getStateCheckTwo(){
        return driver.findElement(checkTwo).isSelected();
    }
}

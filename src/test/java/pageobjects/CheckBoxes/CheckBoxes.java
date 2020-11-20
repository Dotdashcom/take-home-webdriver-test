package pageobjects.CheckBoxes;

import org.openqa.selenium.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

public class CheckBoxes {
    protected WebDriver driver;
    private static final long DEFAULT_PAUSE = 2000;
    private static List<WebElement> elCheckBoxes;
    private static HashMap<Integer, Boolean> originalStates = new HashMap<>();
    private static HashMap<Integer, Boolean> actualStates = new HashMap<>();
    private static By byCheckBoxes = By.xpath("//form/input[@type='checkbox']");

    public CheckBoxes(WebDriver driver){
        this.driver = driver;
    }

    public HashMap orgChecked() {
        try {
            elCheckBoxes = driver.findElements(byCheckBoxes);

            for (int i=0; i<elCheckBoxes.size(); i++){
                //System.out.println("CheckBox: #" +Integer.toString(i+1)+ " " + elCheckBoxes.get(i).isSelected());
                originalStates.put(i, elCheckBoxes.get(i).isSelected());
            }
        } catch (NoSuchElementException e) {
        } catch (ElementNotVisibleException e) {
        } catch (TimeoutException e) {
        }

        return originalStates;
    }

    public HashMap clkChecked() throws InterruptedException {
        try {
            elCheckBoxes = driver.findElements(byCheckBoxes);

            for (int i=0; i<elCheckBoxes.size(); i++){
                elCheckBoxes.get(i).click();
                Thread.sleep(DEFAULT_PAUSE);

                //System.out.println("CheckBox: #" +Integer.toString(i+1)+ " " + elCheckBoxes.get(i).isSelected());
                actualStates.put(i, elCheckBoxes.get(i).isSelected());
            }
        } catch (NoSuchElementException e) {
        } catch (ElementNotVisibleException e) {
        } catch (TimeoutException e) {
        }

        return actualStates;
    }

}

package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CheckBoxPage extends SeleniumLibrary
       {
        public CheckBoxPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(how = How.XPATH,using = "(//input[@type='checkbox'])[1]")
        WebElement checkBox1;

        @FindBy(how = How.XPATH , using = "(//input[@type='checkbox'])[2]")
        WebElement checkBox2;

        public void clickCheckBox1()
        {
            clickOnElement(checkBox1);
        }

        public void clickCheckBox2()
        {
           clickOnElement(checkBox2);
        }

        public boolean validateCheckBox1Selected()
        {
          return isElementSelected(checkBox1);
        }

        public boolean validateCheckBox2Selected()
        {
          return isElementSelected(checkBox2);
        }
    }



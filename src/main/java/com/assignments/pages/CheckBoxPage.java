package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;

public final class CheckBoxPage extends BasePage {
    private final By checkBox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private final By checkBox2 = By.xpath("(//input[@type='checkbox'])[2]");

    public void clickOnCheckBox1() {
        click(checkBox1, CLICKABLE, "First Check Box");
    }
    public void clickOnCheckBox2() {
        click(checkBox2, CLICKABLE, "Second Check Box");
    }

    public boolean isCheckBox1Selected() {
        return isSelected(checkBox1, CLICKABLE, "CHeck Box 1");
    }

    public boolean isCheckBox2Selected() {
        return isSelected(checkBox2, CLICKABLE, "Check Box 2");
    }
}

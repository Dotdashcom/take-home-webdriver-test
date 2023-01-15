package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.enums.WaitStrategy.CLICKABLE;

public final class HomePage extends BasePage {

  public void clickOnLink(String name) {
    click(By.linkText(name), CLICKABLE, name);
  }
}

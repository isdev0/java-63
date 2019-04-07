package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);

        if( text !=null && !text.equals(wd.findElement(locator).getAttribute("value")) ) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void select(String name, String text) {
        click(By.name(name));
        new Select(wd.findElement(By.name(name))).selectByVisibleText(text);
//        click(By.cssSelector("select[name=\"" + name + "\"] > option[value=\"" + text + "\"]"));
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}

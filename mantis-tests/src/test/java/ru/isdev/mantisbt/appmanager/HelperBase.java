package ru.isdev.mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {

    protected ApplicationManger app;
    protected WebDriver wd;

    public HelperBase(ApplicationManger app) {
        this.app = app;
        this.wd = app.getDriver();
    }

    protected void type(By locator, String text) {
        click(locator);

        if( text !=null && !text.equals(wd.findElement(locator).getAttribute("value")) ) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    protected void attach(By locator, File file) {
        if(file != null){
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
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

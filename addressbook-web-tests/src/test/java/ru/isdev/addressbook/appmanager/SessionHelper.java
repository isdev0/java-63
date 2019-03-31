package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper {
    private FirefoxDriver wd;
    private NavigationHelper navigationHelper;

    public SessionHelper(FirefoxDriver wd) {
        this.wd = wd;
        this.navigationHelper = new NavigationHelper(this.wd);
    }

    public void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        navigationHelper.goToTheMainPage();
        wd.findElement(By.linkText("Logout")).click();
    }

}

package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {
    private NavigationHelper navigationHelper;

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
        this.navigationHelper = new NavigationHelper(this.wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),username);
        type(By.name("pass"),password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        navigationHelper.goToTheMainPage();
        click(By.linkText("Logout"));
    }

}

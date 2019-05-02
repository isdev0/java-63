package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    private NavigationHelper navigationHelper;

    public SessionHelper(WebDriver wd) {
        super(wd);
        this.navigationHelper = new NavigationHelper(this.wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),username);
        type(By.name("pass"),password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        navigationHelper.theMainPage();
        click(By.linkText("Logout"));
    }

}

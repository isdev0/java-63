package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SessionHelper extends HelperBase {
    private NavigationHelper navigationHelper;
    private Properties properties;

    public SessionHelper(WebDriver wd, Properties properties) {
        super(wd);
        this.properties = properties;
        this.navigationHelper = new NavigationHelper(this.wd, this.properties);
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

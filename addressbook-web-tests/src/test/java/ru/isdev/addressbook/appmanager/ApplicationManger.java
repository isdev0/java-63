package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManger {
    
    public FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;

    public void init() {

        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        sessionHelper       = new SessionHelper(wd);
        navigationHelper    = new NavigationHelper(wd);
        groupHelper         = new GroupHelper(wd);
        contactHelper       = new ContactHelper(wd);

        navigationHelper.goToTheMainPage();
        sessionHelper.login("admin", "secret");

    }

    public void stop() {
        sessionHelper.logout();
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}

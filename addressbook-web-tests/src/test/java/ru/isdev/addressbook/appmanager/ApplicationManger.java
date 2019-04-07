package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManger {

    private final String browser;
    public WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;

    public ApplicationManger(String browser) {
        this.browser = browser;
    }

    public void init() {

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();

        }else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();

        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();

        }else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

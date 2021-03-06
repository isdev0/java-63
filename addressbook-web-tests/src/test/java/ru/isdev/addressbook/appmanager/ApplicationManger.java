package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManger {

    private final String browser;
    private final Properties properties;
    public WebDriver wd;

    private SessionHelper    sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper    contactHelper;
    private GroupHelper      groupHelper;
    private DbHelper         dbHelper;

    public ApplicationManger(String browser){
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        dbHelper = new DbHelper();

        String target = System.getProperty("target","local");
        properties.load(
                new FileReader(
                        new File(
                                String.format("src/test/resources/%s.properties", target)
                        )
                )
        );

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();

        }else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();

        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();

        }else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("wd.implicitlyWait")), TimeUnit.SECONDS);

        sessionHelper       = new SessionHelper(wd,properties);
        navigationHelper    = new NavigationHelper(wd,properties);
        groupHelper         = new GroupHelper(wd);
        contactHelper       = new ContactHelper(wd);

        navigationHelper.theMainPage();
        sessionHelper.login(
                properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPass")
        );

    }

    public void stop() {
        sessionHelper.logout();
        wd.quit();
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public DbHelper db() {
        return dbHelper;
    }

}

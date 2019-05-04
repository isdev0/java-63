package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class NavigationHelper extends HelperBase {

    private Properties properties;

    public NavigationHelper(WebDriver wd, Properties properties) {
        super(wd);
        this.properties = properties;
    }

    private void thePage(String page) {
        wd.get(properties.getProperty("web.baseUrl") + page);
    }

    public void theMainPage(){
        thePage("index.php");
    }

    public void theContactPage(){
        theMainPage();
    }

    public void theGroupPage() {
        click(By.linkText("groups"));
    }

}

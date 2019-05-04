package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    private void thePage(String page) {
        String baseUrl = "http://localhost/addressbook/";
        wd.get(baseUrl + page);
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

package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void goToTheMainPage(){
        goToThePage("index.php");
    }

    public void goToTheContactsPage(){
        goToTheMainPage();
    }

    private void goToThePage(String page) {
        wd.get("http://localhost/addressbook/" + page);
    }
}

package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    private void goToThePage(String page) {
        wd.get("http://localhost/addressbook/" + page);
    }

    public void goToTheMainPage(){
        goToThePage("index.php");
    }

    public void goToTheContactsPage(){
        goToTheMainPage();
    }

    public void goToTheGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void returnToTheGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

}

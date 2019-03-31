package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
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
        click(By.linkText("groups"));
    }

    public void returnToTheGroupPage() {
        click(By.linkText("group page"));
    }

}

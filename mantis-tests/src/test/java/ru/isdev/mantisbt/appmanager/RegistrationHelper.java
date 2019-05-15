package ru.isdev.mantisbt.appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper {

    private final ApplicationManger app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManger app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}

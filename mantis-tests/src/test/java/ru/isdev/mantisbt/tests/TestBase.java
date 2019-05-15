package ru.isdev.mantisbt.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.isdev.mantisbt.appmanager.ApplicationManger;

public class TestBase {

    protected static final ApplicationManger app = new ApplicationManger(
            System.getProperty("browser", BrowserType.FIREFOX)
    );

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}

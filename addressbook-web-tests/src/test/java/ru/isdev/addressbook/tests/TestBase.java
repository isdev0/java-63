package ru.isdev.addressbook.tests;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.isdev.addressbook.appmanager.ApplicationManger;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

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

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters" + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListInUI() {

        if(Boolean.getBoolean("verfyUI")) {

            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();

            assertThat(uiGroups, equalTo(
                    dbGroups.stream().map(
                            (g) -> new GroupData()
                                    .withId(g.getId())
                                    .withName(g.getName())
                    ).collect(Collectors.toSet())
                    )
            );
        }
    }

}

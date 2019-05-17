package ru.isdev.mantisbt.tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class UserPasswordChangeTests extends TestBase {

    @Test
    public void testUserPasswordChange() throws IOException, InterruptedException {

        String username = "user2";

        app.registration().logon(app.getProperty("web.adminLogin"), app.getProperty("web.adminPass"));
        app.registration().resetUserPassword(username);
        
    }
}

package ru.isdev.mantisbt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.mantisbt.model.MailMessage;
import ru.isdev.mantisbt.model.UserData;
import ru.isdev.mantisbt.model.Users;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class UserPasswordChangeTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testUserPasswordChange() throws IOException, MessagingException, InterruptedException {

        long now = System.currentTimeMillis();

//        String email = String.format("user%s@localhost", now);
//        String user = String.format("user%s", now);
//        String password = "password";
        String newpassword = String.format("%s", now);

//        app.james().createUser(user,password);
//        app.registration().start(user, email);

//        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
//
//        app.registration().finish(findConfirmationLink(mailMessages, email, app.getProperty("mantisbt.registration")), password);
//        app.registration().logout();

        UserData dbuser = app.user().all().iterator().next();
        String user = dbuser.getUsername();
        String email = dbuser.getEmail();

        app.registration().logon(app.getProperty("web.adminLogin"), app.getProperty("web.adminPass"));
        app.registration().resetUserPassword(user);

        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmUrl = findConfirmationLink(mailMessages, email, app.getProperty("mantisbt.passwordreset"));
        app.registration().finish(confirmUrl, newpassword);

        assertTrue(app.newSession().login(user,newpassword));


    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email, String subject) {

        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).filter((s) -> s.subject.equals(subject)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();

        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }

}

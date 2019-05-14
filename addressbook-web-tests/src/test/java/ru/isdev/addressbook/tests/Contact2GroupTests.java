package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class Contact2GroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().theContactPage();
        if(app.db().contacts().size() == 0) {
            app.contact().createDefaultContact();
        }

        if(app.db().groups().size() == 0) {
            app.goTo().theGroupPage();
            app.group().createDefaultGroup();
        }

        app.goTo().theContactPage();
    }

    @Test
    public void testAddContactToGroup(){

        ContactData contact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();

        app.contact().selectById(contact.getId());
        app.contact().addToGroup(group);

        app.db().refresh(contact);
        assertThat(contact.getGroups(), hasItem(group));

    }

}

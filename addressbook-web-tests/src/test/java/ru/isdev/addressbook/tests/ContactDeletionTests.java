package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theContactPage();
        if(app.db().contacts().size() == 0) {
            app.contact().createDefaultContact();
        }
    }

    @Test
    public void testContactDeletion(){

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();

        app.contact().delete(deletedContact);
        // I had to add one more relocation due to FF being too slow to remove deleted objects from the DOM
        app.goTo().theContactPage();

        Contacts after = app.contact().all();

        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo( before.without(deletedContact) ));
    }

}

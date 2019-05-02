package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theContactPage();
        app.contact().checkContactPresence();
    }

    @Test
    public void testContactDeletion(){

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;

        app.contact().select(index);
        app.contact().deleteSelectedContacts();

        // I had to add one more relocation due to FF being too slow to remove deleted objects from the DOM
        app.goTo().theContactPage();
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}

package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToTheContactsPage();
        app.getContactHelper().checkContactPresence();

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();

        // I had to add one more relocation due to FF being too slow to remove deleted objects from the DOM
        app.getNavigationHelper().goToTheContactsPage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}

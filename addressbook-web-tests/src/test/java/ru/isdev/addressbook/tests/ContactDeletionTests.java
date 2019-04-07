package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToTheContactsPage();
        app.getContactHelper().checkContactPresence();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
    }

}

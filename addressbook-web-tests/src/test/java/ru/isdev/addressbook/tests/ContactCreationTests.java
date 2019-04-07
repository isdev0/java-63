package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() throws Exception {

        app.getNavigationHelper().goToTheContactsPage();
        app.getContactHelper().createContact(
                new ContactData(
                        "fname",
                        "mname",
                        "lname",
                        "nname",
                        "title",
                        "company",
                        "address1\naddress2\naddress3",
                        "thome",
                        "tmobile",
                        "twork",
                        "tfax",
                        "email1",
                        "email2",
                        "email3",
                        "hpage",
                        "1",
                        "January",
                        "2000",
                        "10",
                        "October",
                        "2010",
                        "secaddress1\nsecaddress2\nsecaddress3",
                        "sechome",
                        "note1\nnote2\nnote3"
                )
        );
    }

}

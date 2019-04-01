package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){

        app.getNavigationHelper().goToTheContactsPage();

        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(
                new ContactData(
                        "fname_edited",
                        "mname_edited",
                        "lname_edited",
                        "nname_edited",
                        "title_edited",
                        "company_edited",
                        "address1_edited\naddress2_edited\naddress3_edited",
                        "thome_edited",
                        "tmobile_edited",
                        "twork_edited",
                        "tfax_edited",
                        "email1_edited",
                        "email2_edited",
                        "email3_edited",
                        "hpage_edited",
                        "3",
                        "March",
                        "2003",
                        "12",
                        "December",
                        "2012",
                        "secaddress1_edited\nsecaddress2_edited\nsecaddress3_edited",
                        "sechome_edited",
                        "note1_edited\nnote2_edited\nnote3_edited"
                )
        );
        app.getContactHelper().submitContactModification();
    }

}

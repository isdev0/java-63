package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theContactPage();
        app.contact().checkContactPresence();
    }

    @Test
    public void testContactModification(){

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();


        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFname("fname_edited")
                .withMname("mname_edited")
                .withLname("lname_edited")
                .withNname("nname_edited")
                .withTitle("title_edited")
                .withCompany("company_edited")
                .withAddress("address1_edited\naddress2_edited\naddress3_edited")
                .withThome("thome_edited")
                .withTmobile("tmobile_edited")
                .withTwork("twork_edited")
                .withTfax("tfax_edited")
                .withEmail("email1_edited")
                .withEmail2("email2_edited")
                .withEmail3("email3_edited")
                .withHpage("hpage_edited")
                .withBday("3")
                .withBmonth("March")
                .withByear("2003")
                .withAday("12")
                .withAmonth("December")
                .withAyear("2012")
                .withAddress2("secaddress1_edited\nsecaddress2_edited\nsecaddress3_edited")
                .withPhone2("sechome_edited")
                .withNotes("note1_edited\nnote2_edited\nnote3_edited");
        app.contact().modify(contact);

        Contacts after = app.contact().all();

        assertEquals(after.size(), before.size());
        assertThat(after, equalTo( before
                .without(modifiedContact)
                .withAdded(contact)
                )
        );

    }

}

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
        if(app.db().contacts().size() == 0) {
            app.contact().createDefaultContact();
        }
    }

    @Test
    public void testContactModification(){

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();


        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFname("fname_edited")
                .withMname("mname_edited")
                .withLname("lname_edited")
                .withNname("nname_edited")
                .withTitle("title_edited")
                .withCompany("company_edited")
                .withAddress("address1_edited\r\naddress2_edited\r\naddress3_edited")
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
                .withAddress2("secaddress1_edited\r\nsecaddress2_edited\r\nsecaddress3_edited")
                .withPhone2("sechome_edited")
                .withNotes("note1_edited\r\nnote2_edited\r\nnote3_edited");
        app.contact().modify(contact);

        Contacts after = app.db().contacts();
        Contacts before_after = before.without(modifiedContact).withAdded(contact);

        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before_after));

    }

}

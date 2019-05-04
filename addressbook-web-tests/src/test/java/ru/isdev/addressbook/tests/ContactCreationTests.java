package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theContactPage();
    }

    @Test()
    public void testContactCreation() throws Exception {

        File photo = new File("src/test/resources/avatar.png");

        Contacts before = app.contact().all();

        ContactData contact = new ContactData()
                .withFname("fname")
                .withMname("mname")
                .withLname("lname")
                .withNname("nname")
                .withTitle("title")
                .withCompany("company")
                .withAddress("address1\naddress2\naddress3")
                .withThome("thome")
                .withTmobile("tmobile")
                .withTwork("twork")
                .withTfax("tfax")
                .withEmail("email1")
                .withEmail2("email2")
                .withEmail3("email3")
                .withHpage("hpage")
                .withBday("1")
                .withBmonth("January")
                .withByear("2000")
                .withAday("10")
                .withAmonth("October")
                .withAyear("2010")
                .withAddress2("secaddress1\nsecaddress2\nsecaddress3")
                .withPhone2("sechome")
                .withNotes("note1\nnote2\nnote3")
                .withPhoto(photo)
                ;
        app.contact().create(contact);

        Contacts after = app.contact().all();

        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(
                        contact.withId(
                                after.stream().mapToInt(ContactData::getId).max().getAsInt()
                        )
                )
            )
        );
    }

}

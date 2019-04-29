package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() throws Exception {

        int maxIndex;

        ContactData contact = new ContactData(
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
        );

        app.getNavigationHelper().goToTheContactsPage();
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);

        maxIndex = after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId();

        contact.setId(maxIndex);
        before.add(contact);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}

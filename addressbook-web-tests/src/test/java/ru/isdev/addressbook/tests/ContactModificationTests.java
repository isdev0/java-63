package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){

        ContactData contact = new ContactData(
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
        );

        app.getNavigationHelper().goToTheContactsPage();
        app.getContactHelper().checkContactPresence();

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().initContactModification(before.size()-1);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        before.set(before.size() - 1, contact).setId(after.get(after.size() - 1).getId());

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        // not necessary but not redundant yet assert (using sort comparator)
        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}

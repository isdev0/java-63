package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @Test()
    public void testContactAddress(){

        app.goTo().theMainPage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo( mergeAddresses(contactInfoFromEditForm) ));
    }

    @Test()
    public void testContactEmails(){

        app.goTo().theMainPage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmails(), equalTo( mergeEmails(contactInfoFromEditForm) ));
    }

    private String mergeAddresses(ContactData contact) {
        String[] addresses = contact.getAddress().split("\n");
        String mergedAddresses = "";
        for(int i = 0; i < addresses.length; i++){
            mergedAddresses = mergedAddresses + addresses[i].trim();
            if(i != (addresses.length - 1)) {
                mergedAddresses = mergedAddresses + "\n";
            }
        }
        return mergedAddresses;
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(
                contact.getEmail(),
                contact.getEmail2(),
                contact.getEmail3()
        ).stream()
                .filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }


}


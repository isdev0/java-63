package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test(enabled = true)
    public void testContactPhones(){

        app.goTo().theMainPage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getThome(),  equalTo( cleaned( contactInfoFromEditForm.getThome()    )));
        assertThat(contact.getTmobile(),equalTo( cleaned( contactInfoFromEditForm.getTmobile()  )));
        assertThat(contact.getTwork(),  equalTo( cleaned( contactInfoFromEditForm.getTwork()    )));
    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}

package ru.isdev.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.Contacts;
import ru.isdev.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts_XML() throws IOException {

        try(
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File("src/test/resources/contacts.xml")
                    )
            )
        ){

            String line = reader.readLine();
            String xml = "";

            while (line != null) {
                xml += line;
                line = reader.readLine();
            }

            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);

            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);

            return contacts.stream()
                    .map((g) -> new Object[]{g})
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContacts_JSON() throws IOException {

        try(
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File("src/test/resources/contacts.json")
                    )
            )
        ){
            String line = reader.readLine();
            String json = "";

            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());

            return contacts.stream()
                    .map((g) -> new Object[]{g})
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theContactPage();
    }

    @Test(dataProvider = "validContacts_JSON")
    public void testContactCreation(ContactData contact) throws Exception {

        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();

        contact
                .withPhoto(new File("src/test/resources/avatar.png"))
                .inGroup(groups.iterator().next());

        app.contact().create(contact);

        Contacts after = app.db().contacts();

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

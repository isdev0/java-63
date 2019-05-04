package ru.isdev.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.isdev.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contacts count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {

        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);

        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);

        if(format.equals("xml")) {
            saveAsXML(contacts, new File(file));

        }else if(format.equals("json")) {
            saveAsJSON(contacts, new File(file));

        }else{
            System.out.println("Data format is not recognized");
        }
    }

    private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        String json = gson.toJson(contacts);

        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {

        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);

        String xml = xstream.toXML(contacts);

        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 1; i <= count; i++){
            contacts.add(new ContactData()
                    .withFname(String.format("fname_default%s", i))
                    .withMname(String.format("mname_default%s", i))
                    .withLname(String.format("lname_default%s", i))
                    .withNname(String.format("nname_default%s", i))
                    .withTitle(String.format("title_default%s", i))
                    .withCompany(String.format("company_default%s", i))
                    .withAddress(String.format("address1_default%s\naddress2_default%s\naddress3_default%s", i,i,i))
                    .withThome(String.format("thome_default%s", i))
                    .withTmobile(String.format("tmobile_default%s", i))
                    .withTwork(String.format("twork_default%s", i))
                    .withTfax(String.format("tfax_default%s", i))
                    .withEmail(String.format("email1_default%s", i))
                    .withEmail2(String.format("email2_default%s", i))
                    .withEmail3(String.format("email3_default%s", i))
                    .withHpage(String.format("hpage_default%s", i))
                    .withBday("1")
                    .withBmonth("January")
                    .withByear("2001")
                    .withAday("2")
                    .withAmonth("January")
                    .withAyear("2002")
                    .withAddress2(String.format("secaddress1_default%s\nsecaddress2_default%s\nsecaddress3_default%s", i,i,i))
                    .withPhone2(String.format("sechome_default%s", i))
                    .withNotes(String.format("note1_default%s\nnote2_default%s\nnote3_default%s", i,i,i))
            );
        }
        return contacts;
    }

}

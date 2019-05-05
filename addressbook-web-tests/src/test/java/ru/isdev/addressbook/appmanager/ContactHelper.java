package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.isdev.addressbook.model.ContactData;
import ru.isdev.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFname());
        type(By.name("middlename"),contactData.getMname());
        type(By.name("lastname"),contactData.getLname());
        type(By.name("nickname"),contactData.getNname());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getThome());
        type(By.name("mobile"),contactData.getTmobile());
        type(By.name("work"),contactData.getTwork());
        type(By.name("fax"),contactData.getTfax());
        type(By.name("email"),contactData.getEmail());
        type(By.name("email2"),contactData.getEmail2());
        type(By.name("email3"),contactData.getEmail3());
        type(By.name("homepage"),contactData.getHpage());
        select("bday",contactData.getBday());
        select("bmonth",contactData.getBmonth());
        type(By.name("byear"),contactData.getByear());
        select("aday",contactData.getAday());
        select("amonth",contactData.getAmonth());
        type(By.name("ayear"),contactData.getAyear());
        type(By.name("address2"),contactData.getAddress2());
        type(By.name("phone2"),contactData.getPhone2());
        type(By.name("notes"),contactData.getNotes());
        attach(By.name("photo"),contactData.getPhoto());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void delete(ContactData contact) {
        selectById(contact.getId());
        deleteSelectedContacts();
    }

    public void initContactModificationByIndex(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void createDefaultContact() {
        create(
                new ContactData()
                        .withFname("fname_default")
                        .withMname("mname_default")
                        .withLname("lname_default")
                        .withNname("nname_default")
                        .withTitle("title_default")
                        .withCompany("company_default")
                        .withAddress("address1_default\naddress2_default\naddress3_default")
                        .withThome("thome_default")
                        .withTmobile("tmobile_default")
                        .withTwork("twork_default")
                        .withTfax("tfax_default")
                        .withEmail("email1_default")
                        .withEmail2("email2_default")
                        .withEmail3("email3_default")
                        .withHpage("hpage_default")
                        .withBday("1")
                        .withBmonth("January")
                        .withByear("2001")
                        .withAday("2")
                        .withAmonth("January")
                        .withAyear("2002")
                        .withAddress2("secaddress1_default\nsecaddress2_default\nsecaddress3_default")
                        .withPhone2("sechome_default")
                        .withNotes("note1_default\nnote2_default\nnote3_default")
        );
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact);
        submitContactModification();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for(WebElement element: elements){
            List<WebElement> contactRow = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(contactRow.get(0).findElement(By.tagName("input")).getAttribute("Value"));

            String lname = contactRow.get(1).getText();
            String fname = contactRow.get(2).getText();
            String address = contactRow.get(3).getText();
            String emails = contactRow.get(4).getText();
            String phones = contactRow.get(5).getText();

            ContactData contact = new ContactData()
                    .withId(id)
                    .withFname(fname)
                    .withLname(lname)
                    .withAddress(address)
                    .withAllEmails(emails)
                    .withAllPhones(phones);

            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {

        initContactModificationById(contact.getId());

        String fname    = wd.findElement(By.name("firstname")).getAttribute("value");
        String lname    = wd.findElement(By.name("lastname")).getAttribute("value");
        String thome    = wd.findElement(By.name("home")).getAttribute("value");
        String tmobile  = wd.findElement(By.name("mobile")).getAttribute("value");
        String twork    = wd.findElement(By.name("work")).getAttribute("value");
        String sechome  = wd.findElement(By.name("phone2")).getAttribute("value");
        String address  = wd.findElement(By.name("address")).getAttribute("value");
        String email    = wd.findElement(By.name("email")).getAttribute("value");
        String email2   = wd.findElement(By.name("email2")).getAttribute("value");
        String email3   = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();

        return new ContactData()
                .withId(contact.getId())
                .withFname(fname)
                .withLname(lname)
                .withThome(thome)
                .withTmobile(tmobile)
                .withTwork(twork)
                .withPhone2(sechome)
                .withAddress(address)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);
    }
}

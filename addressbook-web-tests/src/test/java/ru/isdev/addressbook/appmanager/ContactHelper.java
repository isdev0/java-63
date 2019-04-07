package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.isdev.addressbook.model.ContactData;

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
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    private boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void checkContactPresence() {
        if( !isThereAnyContact() ) {
            createContact(
                    new ContactData(
                            "fname_default",
                            "mname_default",
                            "lname_default",
                            "nname_default",
                            "title_default",
                            "company_default",
                            "address1_default\naddress2_default\naddress3_default",
                            "thome_default",
                            "tmobile_default",
                            "twork_default",
                            "tfax_default",
                            "email1_default",
                            "email2_default",
                            "email3_default",
                            "hpage_default",
                            "1",
                            "January",
                            "2001",
                            "2",
                            "January",
                            "2002",
                            "secaddress1\nsecaddress2\nsecaddress3",
                            "sechome",
                            "note1\nnote2\nnote3"
                    )
            );
        }
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
    }

}

package ru.isdev.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity @Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField @Id @Column(name = "id")                 private int id = 0;
    @Expose @Column(name = "firstname")                        private String fname;
    @Expose @Column(name = "middlename")                       private String mname;
    @Expose @Column(name = "lastname")                         private String lname;
    @Expose @Column(name = "nickname")                         private String nname;
    @Expose @Column(name = "title")                            private String title;
    @Expose @Column(name = "company")                          private String company;
    @Expose @Column(name = "address")  @Type(type="text")      private String address;
    @Expose @Column(name = "home")     @Type(type="text")      private String thome;
    @Expose @Column(name = "mobile")   @Type(type="text")      private String tmobile;
    @Expose @Column(name = "work")     @Type(type="text")      private String twork;
    @Expose @Column(name = "fax")      @Type(type="text")      private String tfax;
    @Expose @Column(name = "email")    @Type(type="text")      private String email;
    @Expose @Column(name = "email2")   @Type(type="text")      private String email2;
    @Expose @Column(name = "email3")   @Type(type="text")      private String email3;
    @Expose @Column(name = "homepage") @Type(type="text")      private String hpage;
    @Expose @Column(name = "bday", columnDefinition="TINYINT") private String bday;
    @Expose @Column(name = "bmonth")                           private String bmonth;
    @Expose @Column(name = "byear")                            private String byear;
    @Expose @Column(name = "aday", columnDefinition="TINYINT") private String aday;
    @Expose @Column(name = "amonth")                           private String amonth;
    @Expose @Column(name = "ayear")                            private String ayear;
    @Expose @Column(name = "address2") @Type(type="text")      private String address2;
    @Expose @Column(name = "phone2")   @Type(type="text")      private String phone2;
    @Expose @Column(name = "notes")    @Type(type="text")      private String notes;
    @Expose @Transient                                         private String photo;
    @Expose @Transient                                         private String phones;
    @Expose @Transient                                         private String emails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "address_in_groups",
            joinColumns         = @JoinColumn(name = "id"),
            inverseJoinColumns  = @JoinColumn(name = "group_id")
    )
    private Set<GroupData> groups = new HashSet<>();

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    public String getNname() {
        return nname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getThome() {
        return thome;
    }

    public String getTmobile() {
        return tmobile;
    }

    public String getTwork() {
        return twork;
    }

    public String getTfax() {
        return tfax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHpage() {
        return hpage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    public String getEmails() {
        return emails;
    }

    public String getPhones() {
        return phones;
    }

    public File getPhoto() {
        if(photo != null) {
            return new File(photo);
        }else{
            return null;
        }
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFname(String fname) {
        this.fname = fname;
        return this;
    }

    public ContactData withLname(String lname) {
        this.lname = lname;
        return this;
    }

    public ContactData withMname(String mname) {
        this.mname = mname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(fname, that.fname) &&
                Objects.equals(mname, that.mname) &&
                Objects.equals(lname, that.lname) &&
                Objects.equals(nname, that.nname) &&
                Objects.equals(title, that.title) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(thome, that.thome) &&
                Objects.equals(tmobile, that.tmobile) &&
                Objects.equals(twork, that.twork) &&
                Objects.equals(tfax, that.tfax) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3) &&
                Objects.equals(hpage, that.hpage) &&
                Objects.equals(bday, that.bday) &&
                Objects.equals(bmonth, that.bmonth) &&
                Objects.equals(byear, that.byear) &&
                Objects.equals(aday, that.aday) &&
                Objects.equals(ayear, that.ayear) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(phone2, that.phone2) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, mname, lname, nname, title, company, address, thome, tmobile, twork, tfax, email, email2, email3, hpage, bday, bmonth, byear, aday, ayear, address2, phone2, notes);
    }

    public ContactData withNname(String nname) {
        this.nname = nname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withThome(String thome) {
        this.thome = thome;
        return this;
    }

    public ContactData withTmobile(String tmobile) {
        this.tmobile = tmobile;
        return this;
    }

    public ContactData withTwork(String twork) {
        this.twork = twork;
        return this;
    }

    public ContactData withTfax(String tfax) {
        this.tfax = tfax;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHpage(String hpage) {
        this.hpage = hpage;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withAday(String aday) {
        this.aday = aday;
        return this;
    }

    public ContactData withAmonth(String amonth) {
        this.amonth = amonth;
        return this;
    }

    public ContactData withAyear(String ayear) {
        this.ayear = ayear;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withAllEmails(String emails) {
        this.emails = emails;
        return this;
    }

    public ContactData withAllPhones(String phones) {
        this.phones = phones;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public ContactData inGroup(GroupData group) {
        this.groups.add(group);
        return this;
    }

    public ContactData outGroup(GroupData group) {
        this.groups.remove(group);
        return this;
    }
}

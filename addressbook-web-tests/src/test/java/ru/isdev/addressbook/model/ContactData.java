package ru.isdev.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = 0;
    private String fname;
    private String mname;
    private String lname;
    private String nname;
    private String title;
    private String company;
    private String address;
    private String thome;
    private String tmobile;
    private String twork;
    private String tfax;
    private String email;
    private String email2;
    private String email3;
    private String hpage;
    private String bday;
    private String bmonth;
    private String byear;
    private String aday;
    private String amonth;
    private String ayear;
    private String address2;
    private String phone2;
    private String notes;
    private String phones;

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(fname, that.fname) &&
                Objects.equals(lname, that.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname);
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

    public String getPhones() {
        return phones;
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

    public ContactData withAllPhones(String phones) {
        this.phones = phones;
        return this;
    }


    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

}

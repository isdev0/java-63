package ru.isdev.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
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

    public ContactData(String fname, String lname){
        this.id = 0;
        this.fname = fname;
        this.lname = lname;
    }

    public ContactData(String fname, String mname, String lname, String nname, String title, String company, String address, String thome, String tmobile, String twork, String tfax, String email, String email2, String email3, String hpage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String address2, String phone2, String notes) {
        this.id = 0;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.nname = nname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.thome = thome;
        this.tmobile = tmobile;
        this.twork = twork;
        this.tfax = tfax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.hpage = hpage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

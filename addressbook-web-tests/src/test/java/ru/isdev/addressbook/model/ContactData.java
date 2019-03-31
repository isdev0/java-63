package ru.isdev.addressbook.model;

public class ContactData {
    private final String fname;
    private final String mname;
    private final String lname;
    private final String nname;
    private final String title;
    private final String company;
    private final String address;
    private final String thome;
    private final String tmobile;
    private final String twork;
    private final String tfax;
    private final String email;
    private final String email2;
    private final String email3;
    private final String hpage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amonth;
    private final String ayear;
    private final String address2;
    private final String phone2;
    private final String notes;

    public ContactData(String fname, String mname, String lname, String nname, String title, String company, String address, String thome, String tmobile, String twork, String tfax, String email, String email2, String email3, String hpage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String address2, String phone2, String notes) {
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
}

package ru.stqa.pft.addressbook.model;

public class ContactData {
    private  int id;
    private String firstname;
    private String lastname;
    private String group;
    private String workPhone;
    private String homePhone;
    private String mobilePhone;

    public ContactData(String firstname, String lastname, String group) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
    }

    public ContactData() {

    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }


    public int getId() {
        return id;
    }
}

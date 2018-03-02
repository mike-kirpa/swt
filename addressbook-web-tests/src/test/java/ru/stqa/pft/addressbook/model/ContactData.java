package ru.stqa.pft.addressbook.model;

public class ContactData {
    private String firstname;
    private String secondname;

    public ContactData(String firstname, String secondname) {

        this.firstname = firstname;
        this.secondname = secondname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return secondname;
    }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase{

    @Test(enabled = true)
    public void testContactCreation(){
        Groups groups = app.db().groups();
        app.goTo().gotoHomepage();
        app.contact().initContactCreation();
        File photo = new File("src/test/resources/Dr_Evil.jpg");
        ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.goTo().gotoHomepage();
    }
}

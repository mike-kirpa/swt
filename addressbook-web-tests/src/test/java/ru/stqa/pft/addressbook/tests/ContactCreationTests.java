package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase{

    @Test(enabled = false)
    public void testContactCreation(){
        app.goTo().gotoHomepage();
        app.contact().initContactCreation();
        File photo = new File("");
        app.contact().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo), true);
        app.contact().submitContactCreation();
        app.goTo().gotoHomepage();
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
    }
}

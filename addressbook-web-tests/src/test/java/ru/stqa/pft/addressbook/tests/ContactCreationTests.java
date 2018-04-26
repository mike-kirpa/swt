package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test(enabled = false)
    public void testContactCreation(){
        app.goTo().gotoHomepage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(new ContactData("test_name", "test_surname", "test3"), true);
        app.contact().submitContactCreation();
        app.goTo().gotoHomepage();
    }
}
